package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.ASK_AMOUNT
import lotto.Constants.PRICE

fun main() {
    Purchase(askAmount()).lottoNum()
}

fun askAmount(): Int {
    try {
        println(ASK_AMOUNT)
        return validAmount()
    } catch (e: Exception) {
        println(AMOUNT_ERROR)
        return askAmount()
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
