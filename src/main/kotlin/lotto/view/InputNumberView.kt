package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.observer.InputNumberErrorListener
import lotto.viewmodel.InputNumberViewModel

class InputNumberView(private val inputNumberViewModel: InputNumberViewModel): InputNumberErrorListener {
    fun inputLottoNumber() {
        println("\n당첨 번호를 입력해 주세요.")
        val number = Console.readLine()
        inputNumberViewModel.updateLottoNumber(number)
    }

    fun inputBonusNumber() {
        println("\n보너스 번호를 입력해 주세요.")
        val number = Console.readLine()
        inputNumberViewModel.updateBonusNumber(number)
    }

    override fun onLottoNumberError(errorMessage: String) {
        println(errorMessage)
        inputLottoNumber()
    }

    override fun onBonusNumberError(errorMessage: String) {
        println(errorMessage)
        inputBonusNumber()
    }
}