package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.domain.BonusNum
import lotto.domain.Money
import lotto.domain.WinningNum

class Input {
    fun inputMoney(): String {
        println("구입할 금액을 입력해 주세요.")
        val money = Console.readLine()
        Money(money)
        return money
    }

    fun inputWinningNum(): String {
        println("\n당첨 번호를 입력해 주세요.")
        val winningNum = Console.readLine()
        WinningNum(winningNum)
        Lotto(winningNum.split(",").map { it.toInt() }.toList())
        return winningNum
    }

    fun inputBonusNum(): String {
        println("\n보너스 번호를 입력해 주세요.")
        val bonusNum = Console.readLine()
        BonusNum(bonusNum)
        return bonusNum
    }
}

