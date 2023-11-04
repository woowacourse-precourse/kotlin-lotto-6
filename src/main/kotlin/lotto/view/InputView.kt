package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()!!.toInt()
    }

    fun inputWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()!!.toList().map { it.code }
    }

    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()!!.toInt()
    }


}
