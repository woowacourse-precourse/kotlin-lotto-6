package ui

import camp.nextstep.edu.missionutils.Console
import exception.Message

object Input {
    fun inputMoney(): Int {
        println(Message.MESSAGE_INPUT_MONEY)
        return Console.readLine().toInt()
    }
}