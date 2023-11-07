package ui

import exception.Message
import exception.Message.Companion.MESSAGE_PRINT_TICKET_AMOUNT
import lotto.Lottos

object Output {
    fun printLottoCount(count: Int) {
        println("${count}" + MESSAGE_PRINT_TICKET_AMOUNT)
    }

    fun printUserLottos(userLottos: Lottos) {
        userLottos.getUserLotto().forEach {
            println(it.getNumbers().sorted())
        }
    }

    fun printInputWinningNumber() {
        println(Message.MESSAGE_INPUT_WINNING_NUMBER)
    }

    fun printInputBonusNumber() {
        println(Message.MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun printMatchResult(matchResult: MutableList<Int>) {
        println(Message.MESSAGE_WINNING_STATISTICS)
        println(Message.MESSAGE_PRINT_FIFTH + " - " + matchResult[4] + Message.MESSAGE_PRINT_AMOUNT)
        println(Message.MESSAGE_PRINT_FOURTH + " - " + matchResult[3] + Message.MESSAGE_PRINT_AMOUNT)
        println(Message.MESSAGE_PRINT_THIRD + " - " + matchResult[2] + Message.MESSAGE_PRINT_AMOUNT)
        println(Message.MESSAGE_PRINT_SECOND + " - " + matchResult[1] + Message.MESSAGE_PRINT_AMOUNT)
        println(Message.MESSAGE_PRINT_FIRST + " - " + matchResult[0] + Message.MESSAGE_PRINT_AMOUNT)
    }

    fun printEarnRate(earnRate: Double) {
        println(Message.MESSAGE_PRINT_EARN + earnRate + Message.MESSAGE_PRINT_EARN_RATE)
    }
}