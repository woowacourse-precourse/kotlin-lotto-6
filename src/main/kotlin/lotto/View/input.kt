package lotto.View

import camp.nextstep.edu.missionutils.Console

object Input {
    fun readPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }
}
