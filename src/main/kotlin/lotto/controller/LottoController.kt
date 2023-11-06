package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.model.LottoModel
import lotto.enums.Exception
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel, private val lottoView: LottoView) {

    val MIN_LOTTO_NUMBER = 1
    val MAX_LOTTO_NUMBER = 45

    fun startLotto() {
        lottoView.printEnterPurchaseMessage()
        inputPurchaseAmount()
    }

    private fun inputPurchaseAmount() {
        while (true) {
            try {
                lottoModel.generateLottoNumbers(checkPurchaseAmount(readLine()))
                lottoView.displayLottoNumbers(lottoModel.getLottoNumbers())
                lottoView.printEnterWinningNumberMessage()
                inputWinningNumbers()
                break
            } catch (e: IllegalArgumentException) {
                println("${Exception.ERROR_HEADER.message} ${e.message}")
                lottoView.printEnterPurchaseMessage()
            }
        }
    }

    private fun inputWinningNumbers() {
        while (true) {
            try {
                lottoModel.setWinningNumbers(checkWinningNumbers(readLine()))
                lottoView.printEnterBonusNumberMessage()
                inputBonusNumber()
                break
            } catch (e: IllegalArgumentException) {
                println("${Exception.ERROR_HEADER.message} ${e.message}")
                lottoView.printEnterWinningNumberMessage()
            }
        }
    }

    private fun inputBonusNumber() {
        while (true) {
            try {
                checkBonusNumber(readLine())
                lottoView.displayResults(lottoModel.calculateLotto())
                lottoView.displayProfit(lottoModel.calculatorProfit())
                break
            } catch (e: IllegalArgumentException) {
                println("${Exception.ERROR_HEADER.message} ${e.message}")
                lottoView.printEnterBonusNumberMessage()
            }
        }
    }

    private fun checkPurchaseAmount(purchaseAmount: String): Int {
        require(purchaseAmount.isNotBlank() && purchaseAmount.isNotEmpty()) { Exception.INPUT_IS_BLANK.message }
        require(purchaseAmount.isDigit()) { Exception.NOT_NUMBER.message }
        val amount = purchaseAmount.toInt()
        require(amount > 0 && amount % 1000 == 0) { Exception.AMOUNT_MUST_BE_THOUSAND_WON.message }

        return amount
    }

    private fun checkWinningNumbers(winningNumbers: String): String {
        val splitWinningNumbers = winningNumbers.split(",")
        require(splitWinningNumbers.size == 6) { Exception.INVALID_COUNT.message }
        require(splitWinningNumbers.all { it.isNotBlank() && it.isNotEmpty() }) { Exception.INPUT_IS_BLANK.message }
        require(splitWinningNumbers.all { it.isDigit() }) { Exception.NOT_NUMBER.message }
        require(splitWinningNumbers.toSet().size == 6) { Exception.DUPLICATED_NUMBER.message }
        require(splitWinningNumbers.all { it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { Exception.INVALID_RANGE_NUMBER.message }

        return winningNumbers
    }

    private fun checkBonusNumber(bonusNumber: String) {
        require(bonusNumber.isNotBlank() && bonusNumber.isNotEmpty()) { Exception.INPUT_IS_BLANK.message }
        require(bonusNumber.isDigit()) { Exception.NOT_NUMBER.message }
        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER ) { Exception.INVALID_RANGE_NUMBER.message }
        require(lottoModel.getWinningNumber().none() { it == bonusNumber }) { Exception.DUPLICATED_BONUS_NUMBER.message }

        lottoModel.setBonusNumbers(bonusNumber)
    }

    private fun String.isDigit(): Boolean {
        return all { it.isDigit() }
    }
}