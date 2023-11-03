package lotto

import lotto.constants.WinningResult
import lotto.io.input.Input
import lotto.io.output.Output
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.WinningLotto

class LottoController(
    private val input: Input,
    private val output: Output,
    private val lottoSupplier: LottoSupplier
) {
    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private var totalWinningAmount: Long = 0

    fun readyWinningCounts() {
        WinningResult.entries.forEach { winningResult ->
            if (winningResult == WinningResult.NOT_WINNING) {
                return@forEach
            }

            winningCounts[winningResult] = 0
        }
    }

    fun run() {
        readyWinningCounts()

        output.printInputAmount()
        val amount = input.inputAmount()

        val purchaseCount = amount.getPurchaseCount()
        output.printPurchaseCount(purchaseCount)

        val lottos = lottoSupplier.supplyLottos(purchaseCount)
        output.printLottos(lottos)

        output.printInputWinningNumbers()
        val winningNumbers = input.inputWinningLotto()

        output.printInputBonusNumber()
        val winningBonusNumber = input.inputBonusNumber()

        val winningLotto = WinningLotto(winningNumbers, winningBonusNumber)

        calculateWinningCounts(lottos, winningLotto)

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

    fun getTotalReturn(totalWinningAmount: Long, purchaseCount: Int) =
        totalWinningAmount.toDouble() / purchaseCount
}