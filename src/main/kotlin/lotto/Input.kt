package lotto

import camp.nextstep.edu.missionutils.Console

object Input {
    fun inputAmount(): Int {
        return Console.readLine().toInt()
    }

    fun inputWinningNumber(): List<String> {
        return Console.readLine().trim().split(",")
    }
}