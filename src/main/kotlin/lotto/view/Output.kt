package lotto.view

import lotto.util.Constants.OUTPUT_NUMBER

class Output {

    fun outputNumber(num: Int) {
        println("${num}" + OUTPUT_NUMBER)
    }

    fun <T> outputTickets(ticket: List<T>) {
        println(ticket.joinToString(", ", "[", "]"))
    }
}