package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.ASK_AMOUNT
import lotto.Constants.PRICE

fun main() {
    askAmount()
}

fun askAmount() {
    try {
        println(ASK_AMOUNT)
        validAmount()
    } catch (e: Exception) {
        println(AMOUNT_ERROR)
        askAmount()
    }
}

fun validAmount(): Int {
    try {
        val cost = Console.readLine().toInt()
        require(cost % PRICE == 0 && cost >= PRICE) { AMOUNT_ERROR }
        return cost
    } catch (e: Exception) {
        throw IllegalArgumentException(AMOUNT_ERROR)
    }
}
