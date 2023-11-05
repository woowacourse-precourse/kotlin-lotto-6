package ui

import camp.nextstep.edu.missionutils.Console
import exception.Message

class Input {
    fun inputMoney(): Int {
        println(Message.MESSAGE_INPUT_MONEY)
        return Console.readLine().toInt()
    }
}