package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println("\n당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("\n보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }
}