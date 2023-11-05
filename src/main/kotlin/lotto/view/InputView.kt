package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readInputMoneyFromUser(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().trim()
    }

    fun readWinningNumbersFromUser(): String {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }
}