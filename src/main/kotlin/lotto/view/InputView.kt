package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun inputPrice(): String {
        return Console.readLine()
    }

    fun inputNumbers() : String{
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun inputBonusNumber(): String{
        println()
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }


}