package lotto

import camp.nextstep.edu.missionutils.Console

class LottoMachine {

    fun inputWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()
        return winningNumbers.split(",").map { it.toInt() }.toList()
    }
}