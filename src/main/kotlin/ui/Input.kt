package ui

import camp.nextstep.edu.missionutils.Console

object Input {
    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }

    fun getInputWinningNumber(): MutableList<Int> {
        val winningNumber = mutableListOf<Int>()
        val input: List<String> = Console.readLine().split(",")
        input.forEach {
            winningNumber.add(it.toInt())
        }
        return winningNumber
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}