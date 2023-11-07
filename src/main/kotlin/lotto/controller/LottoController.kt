package lotto.controller

import camp.nextstep.edu.missionutils.Console.readLine
import lotto.model.LottoModel
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_AMOUNT
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_BONUS_NUMBER
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_WINNING_NUMBER
import lotto.util.ValidationUtil
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
                val amount = readLine()
                ValidationUtil.checkPurchaseAmount(amount)
                lottoModel.generateLottoNumbers(amount.toInt())
                break
            } catch (e: IllegalArgumentException) {
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_AMOUNT, e)
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
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_WINNING_NUMBER, e)
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
                lottoView.printErrorAndRetryMessage(PLEASE_INPUT_BONUS_NUMBER, e)
            }
        }
    }
}