package lotto.view

import camp.nextstep.edu.missionutils.Console

class WinningNumberInputView {
    var winningNumber = ""
        private set

    fun input() {
        println("당첨 번호를 입력해 주세요.")
        winningNumber = Console.readLine().trim()
        println()
    }
}