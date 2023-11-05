package lotto

import lotto.constants.WinningResult
import lotto.io.input.Input
import lotto.io.output.Output
import lotto.model.*
import lotto.model.lotto.Lotto
import lotto.model.lotto.LottoSupplier
import lotto.model.lotto.Lottos
import lotto.model.lotto.WinningLotto
import lotto.utils.retryWhileNoException

class LottoController(
    private val input: Input,
    private val output: Output,
    private val lottoSupplier: LottoSupplier
) {
    private var totalWinningAmount: Long = 0

    private val winningCounts: MutableMap<WinningResult, Int> by lazy { readyWinningCounts() }
    private val purchaseCount: PurchaseCount by lazy { readyPurchaseCount() }
    private val purchaseLottos: Lottos by lazy { readyPurchaseLottos() }
    private val winningLotto: WinningLotto by lazy { readyWinningLotto() }

    private fun readyWinningCounts(): MutableMap<WinningResult, Int> =
        mutableMapOf<WinningResult, Int>().apply {
            WinningResult.entries.forEach { winningResult ->
                if (winningResult == WinningResult.NOT_WINNING) {
                    return@forEach
                }

                this[winningResult] = 0
            }
        }

    private fun readyPurchaseCount(): PurchaseCount {
        val purchaseCount = retryWhileNoException {
            output.printInputAmount()
            val purchaseAmount = input.inputPurchaseAmount()
            PurchaseCount(purchaseAmount.amount)
        } as PurchaseCount

        return purchaseCount.also {
            output.printPurchaseCount(it)
        }
    }

    private fun readyPurchaseLottos() =
        lottoSupplier.supplyLottos(purchaseCount).also {
            output.printLottos(it)
        }

    private fun readyWinningLotto(): WinningLotto {
        val winningNumbers = retryWhileNoException {
            output.printInputWinningNumbers()
            input.inputWinningNumbers()
        } as Lotto

        return retryWhileNoException {
            output.printInputBonusNumber()
            val bonus = input.inputBonusNumber()
            WinningLotto(winningNumbers, bonus)
        } as WinningLotto
    }

    fun run() {
        calculateWinningCounts(purchaseLottos, winningLotto)

        val totalReturn = getTotalReturn(totalWinningAmount, purchaseCount)
        output.printWinningStat(winningCounts, totalReturn)
    }

    fun calculateWinningCounts(lottos: Lottos, winningLotto: WinningLotto) {
        lottos.forEach { lotto ->
            val winningResult = getWinningResult(lotto, winningLotto)

            if (winningCounts.containsKey(winningResult)) {
                winningCounts[winningResult] = winningCounts[winningResult]!! + 1
            }

            totalWinningAmount += winningResult.amount
        }
    }

    fun getWinningResult(lotto: Lotto, winningLotto: WinningLotto): WinningResult {
        val count = lotto.countMatchingNumber(winningLotto.lotto)

        return when (count) {
            3 -> WinningResult.THREE
            4 -> WinningResult.FOUR
            5 -> {
                if (lotto.isMatchingBonus(winningLotto.bonus)) {
                    WinningResult.FIVE_BONUS
                } else {
                    WinningResult.FIVE
                }
            }

            6 -> WinningResult.SIX
            else -> WinningResult.NOT_WINNING
        }
    }

    fun getTotalReturn(totalWinningAmount: Long, purchaseCount: PurchaseCount) =
        totalWinningAmount.toDouble() / purchaseCount.count / 10
}