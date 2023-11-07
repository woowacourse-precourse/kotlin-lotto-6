package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.constants.LottoConstants.THOUSAND_WON
import lotto.model.LottoModel
import lotto.message.Exception.AMOUNT_MUST_BE_THOUSAND_WON
import lotto.message.Exception.DUPLICATED_BONUS_NUMBER
import lotto.message.Exception.DUPLICATED_NUMBER
import lotto.message.Exception.INPUT_IS_BLANK
import lotto.message.Exception.INVALID_COUNT
import lotto.message.Exception.INVALID_RANGE_NUMBER
import lotto.message.Exception.NOT_NUMBER
import lotto.message.OutPut.PLEASE_INPUT_AMOUNT
import lotto.message.OutPut.PLEASE_INPUT_BONUS_NUMBER
import lotto.message.OutPut.PLEASE_INPUT_WINNING_NUMBER
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel, private val lottoView: LottoView) {

    fun startLotto() {
        lottoView.printEnterPurchaseMessage()
        inputPurchaseAmount()
        lottoView.displayLottoNumbers(lottoModel.getLottoNumbers())

        lottoView.printEnterWinningNumberMessage()
        inputWinningNumbers()

        lottoView.printEnterBonusNumberMessage()
        inputBonusNumber()

        lottoView.displayResults(lottoModel.calculateLotto())
        lottoView.displayProfit(lottoModel.calculatorProfit())
    }

    private fun inputPurchaseAmount()  {
        while (true) {
            try {
                checkPurchaseAmount(readLine())
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_AMOUNT, e)
            }
        }
    }

    private fun inputWinningNumbers() {
        while (true) {
            try {
                checkWinningNumbers(readLine())
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_WINNING_NUMBER, e)
            }
        }
    }

    private fun inputBonusNumber() {
        while (true) {
            try {
                checkBonusNumber(readLine())
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_BONUS_NUMBER, e)
            }
        }
    }

    private fun checkPurchaseAmount(purchaseAmount: String): Int {
        require(purchaseAmount.isNotBlank() && purchaseAmount.isNotEmpty()) { INPUT_IS_BLANK }
        require(purchaseAmount.isDigit()) { NOT_NUMBER }
        val amount = purchaseAmount.toInt()
        require(amount > 0 && amount % THOUSAND_WON == 0) { AMOUNT_MUST_BE_THOUSAND_WON }

        lottoModel.generateLottoNumbers(amount)
        return amount
    }

    private fun checkWinningNumbers(winningNumbers: String) {
        val splitWinningNumbers = winningNumbers.split(",")
        require(splitWinningNumbers.size == 6) { INVALID_COUNT }
        require(splitWinningNumbers.all { it.isNotBlank() && it.isNotEmpty() }) { INPUT_IS_BLANK }
        require(splitWinningNumbers.all { it.isDigit() }) { NOT_NUMBER }
        require(splitWinningNumbers.toSet().size == 6) { DUPLICATED_NUMBER }
        require(splitWinningNumbers.all { it.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { INVALID_RANGE_NUMBER }

        lottoModel.setWinningNumbers(winningNumbers)
    }

    private fun checkBonusNumber(bonusNumber: String) {
        require(bonusNumber.isNotBlank() && bonusNumber.isNotEmpty()) { INPUT_IS_BLANK }
        require(bonusNumber.isDigit()) { NOT_NUMBER }
        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER ) { INVALID_RANGE_NUMBER }
        require(lottoModel.getWinningNumber().none() { it == bonusNumber }) { DUPLICATED_BONUS_NUMBER }

        lottoModel.setBonusNumbers(bonusNumber)
    }

    private fun String.isDigit(): Boolean {
        return all { it.isDigit() }
    }
}