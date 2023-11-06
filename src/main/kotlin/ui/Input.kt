package ui

import camp.nextstep.edu.missionutils.Console
import exception.Message

object Input {
    fun inputMoney(): Int {
        println(Message.MESSAGE_INPUT_MONEY)
        return Console.readLine().toInt()
    }

    fun inputWinningNumber(): String {
        val winningNumber = mutableListOf<Int>()
        val input = Console.readLine()
            .trim()
            .split(",")
        input.forEach {
            if (!it.all { Character.isDigit(it) }) {
                throw IllegalArgumentException(Message.MESSAGE_INPUT_WINNING_NUMBER)
            }
           winningNumber.add(it.toInt())
        }
        return winningNumber.joinToString(",")
    }

}