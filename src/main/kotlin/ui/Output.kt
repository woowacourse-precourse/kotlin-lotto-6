package ui

import exception.Message
import exception.Message.Companion.MESSAGE_PRINT_TICKET_AMOUNT
import lotto.UserLotto

object Output  {
    fun printLottoCount(count: Int) {
        println("${count}"+ MESSAGE_PRINT_TICKET_AMOUNT)
    }

    fun printUserLottos(userLottos: UserLotto) {
        userLottos.getUserLotto().forEach {
            println(it.getNumbers())
        }
    }
}