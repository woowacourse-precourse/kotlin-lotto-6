package ui

import camp.nextstep.edu.missionutils.Console
import exception.Message

object Input {
    fun inputMoney(): Int {
        println(Message.MESSAGE_INPUT_MONEY)
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