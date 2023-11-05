package ui

import exception.Message
import exception.Message.Companion.MESSAGE_PRINT_TICKET_AMOUNT

object Output  {
    fun printLottoCount(count: Int) {
        println("${count}"+ MESSAGE_PRINT_TICKET_AMOUNT)
    }
}