package lotto.service

import lotto.domain.WinningLotto
import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Exception
import lotto.view.InputView
import lotto.view.OutputView

class WinningLottoService(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    private var winningNumbers = listOf<Int>()
    private var bonusNumber = 0

    fun makeWinningLotto(): WinningLotto {
        outputView.printInputLuckyNumber()
        inputWinningNumber()
        outputView.printInputBonusNumber()
        inputBonusNumber()
        return WinningLotto(winningNumbers, bonusNumber)
    }

    private fun inputWinningNumber() {
        try {
            winningNumbers = inputView.inputLuckyNumber()
            Exception.validateInputWinningNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningNumber()
        }
    }

    private fun inputBonusNumber() {
        try {
            bonusNumber = inputView.inputBonusNumber()
            Exception.validateInputBonusNumber(bonusNumber)
            require(!winningNumbers.contains(bonusNumber)) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber()
        }
    }
}