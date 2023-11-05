package lotto.domain

import camp.nextstep.edu.missionutils.Console

class WinningNumber {
    private lateinit var winningNumbers: List<Int>

    fun decideWinningNumber() {
        println("당첨 번호를 입력해 주세요.")
        winningNumbers = Console.readLine().split("")
            .map { it.toInt() }
    }
}