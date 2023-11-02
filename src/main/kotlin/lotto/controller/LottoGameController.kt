package lotto.controller

import lotto.domain.BonusNumber
import lotto.domain.Lottoes
import lotto.domain.WinningNumbers
import lotto.service.LottoGameService
import lotto.view.PrintOutputView
import lotto.view.ReadUserInputView

class LottoGameController(
    private val inputView: ReadUserInputView,
    private val outputView: PrintOutputView,
    private val service: LottoGameService
) {
    fun play() {
        val purchaseAmount = requirePurchaseAmount()
        printLottoNumbers(purchaseAmount)
        val winningNumbers = requireWinningNumbers()
        val bonusNumber = requireBonusNumber(winningNumbers)
        printLottoResult(winningNumbers, bonusNumber, purchaseAmount)
    }

    private fun requirePurchaseAmount(): Int {
        while (true) {
            try {
                outputView.printRequirePurchaseAmount()
                return inputView.readUserPurchaseAmountInput()
            } catch (e: Exception) {
                outputView.printError(e.message)
            }
        }
    }

    private fun printLottoNumbers(purchaseAmount: Int) {
        val lottoCount = purchaseAmount / PURCHASE_AMOUNT_UNIT
        outputView.printPurchaseAmount(lottoCount)
        outputView.printRandomWinningNumbers(generateLottoNumbers(lottoCount))
    }

    private fun generateLottoNumbers(lottoCount: Int): Lottoes {
        return service.generateRandomNumbers(lottoCount)
    }

    private fun requireWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                outputView.requireWinningNumber()
                return inputView.readUserWinningNumberInput()
            } catch (e: Exception) {
                outputView.printError(e.message)
            }
        }
    }

    private fun requireBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        while (true) {
            try {
                outputView.requireBonusNumber()
                val bonusNumber = inputView.readUserBonusNumberInput()
                bonusNumber.validateBonusNumber(winningNumbers)
                return bonusNumber
            } catch (e: Exception) {
                outputView.printError(e.message)
            }
        }
    }

    private fun printLottoResult(winningNumbers: WinningNumbers, bonusNumber: BonusNumber, purchaseAmount: Int) {
        val lottoResult = service.calculateLottoResult(winningNumbers, bonusNumber)
        outputView.printLottoSameCount(lottoResult, purchaseAmount)
    }

    companion object {
        private const val PURCHASE_AMOUNT_UNIT = 1000
    }
}