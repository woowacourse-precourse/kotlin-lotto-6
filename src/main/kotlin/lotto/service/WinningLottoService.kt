package lotto.service

import lotto.domain.WinningLotto
import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Exception
import lotto.view.InputView
import lotto.view.OutputView

class WinningLottoService(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()){

    private var luckyNumbers = listOf<Int>()
    private var bonusNumber = 0

    fun makeWinningLotto()  : WinningLotto {
        outputView.printInputLuckyNumber()
        inputLuckyNumber()
        outputView.printInputBonusNumber()
        inputBonusNumber()
        return WinningLotto(luckyNumbers,bonusNumber)
    }

    private fun inputLuckyNumber() {
        try {
            luckyNumbers = inputView.inputLuckyNumber()
            Exception.validateInputLuckyNumber(luckyNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputLuckyNumber()
        }
    }

    private fun inputBonusNumber() {
        try {
            bonusNumber = inputView.inputBonusNumber()
            Exception.validateInputBonusNumber(bonusNumber)
            require(!luckyNumbers.contains(bonusNumber)) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE}
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber()
        }
    }
}