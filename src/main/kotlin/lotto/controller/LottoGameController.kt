package lotto.controller

import lotto.domain.BonusNumber
import lotto.domain.Lottoes
import lotto.domain.PurchasePrice
import lotto.domain.WinningNumbers
import lotto.service.LottoGameService
import lotto.view.PrintOutputView
import lotto.view.ReadUserInputView
import java.util.function.Supplier

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

    private fun <T> normal(supplier: Supplier<T>): T {
        while (true) {
            try {
                return supplier.get()
            } catch (e: Exception) {
                outputView.printError(e.message)
            }
        }
    }

    private fun requirePurchaseAmount(): PurchasePrice {
        return normal {
            outputView.printRequirePurchaseAmount()
            PurchasePrice(inputView.readUserPurchaseAmountInput())
        }
    }

    private fun printLottoNumbers(purchaseAmount: PurchasePrice) {
        outputView.printPurchaseAmount(purchaseAmount.calculateLottoCount())
        outputView.printRandomWinningNumbers(generateLottoNumbers(purchaseAmount.calculateLottoCount()))
    }

    private fun generateLottoNumbers(lottoCount: Int): Lottoes {
        return service.generateRandomNumbers(lottoCount)
    }

    private fun requireWinningNumbers(): WinningNumbers {
        return normal {
            outputView.requireWinningNumber()
            inputView.readUserWinningNumberInput()
        }
    }

    private fun requireBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        return normal {
            outputView.requireBonusNumber()
            val bonusNumber = inputView.readUserBonusNumberInput()
            bonusNumber.validateBonusNumber(winningNumbers)
            bonusNumber
        }
    }

    private fun printLottoResult(
        winningNumbers: WinningNumbers,
        bonusNumber: BonusNumber,
        purchaseAmount: PurchasePrice
    ) {
        val lottoResult = service.calculateLottoResult(winningNumbers, bonusNumber)
        outputView.printLottoSameCount(lottoResult, purchaseAmount.getPurchasePrice())
    }

}