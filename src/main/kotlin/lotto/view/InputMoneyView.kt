package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.observer.InputMoneyErrorListener
import lotto.viewmodel.InputMoneyViewModel

class InputMoneyView(private val inputMoneyViewModel: InputMoneyViewModel): InputMoneyErrorListener {
    fun inputMoney() {
        println("구입금액을 입력해 주세요.")
        val money = Console.readLine()
        inputMoneyViewModel.updateMoney(money)
    }

    override fun onMoneyError(errorMessage: String) {
        println(errorMessage)
        inputMoney()
    }
}