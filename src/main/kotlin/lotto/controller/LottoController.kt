package lotto.controller

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.service.LottoService
import lotto.util.ValidationUtil
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun start() {
        val (purchaseAmount, purchasedLottos) = executeLottoPurchaseFlow()
        val result = executeWinningFlow(purchasedLottos)
        concludeLottoSession(result, purchaseAmount)
    }

    private fun executeLottoPurchaseFlow(): Pair<Int, List<Lotto>> {
        val purchaseAmount = getValidPurchaseAmount()
        val purchaseLottoCount = LottoService.calculateLottoCount(purchaseAmount).also {
            OutputView.printPurchaseLottoCount(it)
        }
        return Pair(purchaseAmount, LottoService.generateLottos(purchaseLottoCount).also {
            OutputView.printPurchaseLottos(it)
        })
    }

    private fun executeWinningFlow(purchasedLottos: List<Lotto>): Map<Rank, Int> {
        val winningNumbers = getValidWinningNumbers()
        val bonusNumber = getValidBonusNumber(winningNumbers)
        return LottoService.calculateResult(purchasedLottos, winningNumbers, bonusNumber).also {
            OutputView.printResult(it)
        }
    }

    private fun concludeLottoSession(result: Map<Rank, Int>, purchaseAmount: Int) {
        val earningRate = LottoService.calculateEarningRate(result, purchaseAmount)
        OutputView.printEarningRate(earningRate)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            val userInputPurchaseAmount = InputView.readPurchaseAmount()
            try {
                ValidationUtil.validatePurchaseAmount(userInputPurchaseAmount)
                return userInputPurchaseAmount.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidWinningNumbers(): List<Int> {
        while (true) {
            val userInputWinningNumbers = InputView.readWinningNumbers()
            try {
                ValidationUtil.validateWinningNumbers(userInputWinningNumbers)
                return userInputWinningNumbers.split(",").map { it.toInt() }.sorted()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            val userInputBonusNumber = InputView.readBonusNumber()
            try {
                ValidationUtil.validateBonusNumber(userInputBonusNumber, winningNumbers)
                return userInputBonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}