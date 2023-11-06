package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import lotto.model.LottoModel
import lotto.enums.Exception
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel, private val lottoView: LottoView) {

    fun startLotto() {
        lottoView.printEnterPurchaseMessage()
        inputPurchaseAmount()
        inputWinningNumbers()
    }

    private fun inputPurchaseAmount() {
        while (true) {
            try {
                val lottoNumbers = lottoModel.generateLottoNumbers(checkPurchaseAmount(readLine()))
                lottoView.displayLottoNumbers(lottoNumbers)
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
                break
            } catch (e: IllegalArgumentException) {
                println("${Exception.ERROR_HEADER.message} ${e.message}")
                lottoView.printEnterPurchaseMessage()
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
        require(splitWinningNumbers.all { it.toInt() in 1..44 }) { Exception.INVALID_RANGE_NUMBER.message }

        return winningNumbers
    }

    private fun String.isDigit(): Boolean {
        return all { it.isDigit() }
    }
}