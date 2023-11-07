package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.model.LottoModel
import lotto.constants.message.OutputMessage
import lotto.util.ValidationUtil
import lotto.view.LottoView

class LottoController(private val lottoModel: LottoModel, private val lottoView: LottoView) {
    fun startLotto() {
        lottoView.displayMessage(OutputMessage.PLEASE_INPUT_AMOUNT)
        inputPurchaseAmount()
        lottoView.displayLottoNumbers(lottoModel.getLottoNumbers())

        lottoView.displayMessage(OutputMessage.PLEASE_INPUT_WINNING_NUMBER)
        inputWinningNumbers()

        lottoView.displayMessage(OutputMessage.PLEASE_INPUT_BONUS_NUMBER)
        inputBonusNumber()

        lottoView.displayResults(lottoModel.calculateLotto())
        lottoView.displayProfit(lottoModel.calculateProfit())
    }

    private fun inputPurchaseAmount() {
        while (true) {
            try {
                val amount = readLine()
                ValidationUtil.checkPurchaseAmount(amount)
                lottoModel.generateLottoNumbers(amount.toInt())
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(OutputMessage.PLEASE_INPUT_AMOUNT, e)
            }
        }
    }

    private fun inputWinningNumbers() {
        while (true) {
            try {
                val winningNumbers = readLine()
                ValidationUtil.checkWinningNumbers(winningNumbers)
                lottoModel.setWinningNumbers(winningNumbers)
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(OutputMessage.PLEASE_INPUT_WINNING_NUMBER, e)
            }
        }
    }

    private fun inputBonusNumber() {
        while (true) {
            try {
                val bonusNumber = readLine()
                ValidationUtil.checkBonusNumber(bonusNumber, lottoModel.getWinningNumber())
                lottoModel.setBonusNumbers(bonusNumber)
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(OutputMessage.PLEASE_INPUT_BONUS_NUMBER, e)
            }
        }
    }
}