package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Money

class Input {
    fun inputMoney(): String {
        println("구입할 금액을 입력해주세요.")
        val money = Console.readLine()
        Money(money)
        return money
    }
}
