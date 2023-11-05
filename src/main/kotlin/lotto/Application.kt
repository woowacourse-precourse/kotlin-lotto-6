package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.ASK_AMOUNT
import lotto.Constants.ASK_WIN_NUM
import lotto.Constants.COUNT
import lotto.Constants.END
import lotto.Constants.PRICE
import lotto.Constants.START
import lotto.Constants.WIN_NUM_ERROR

fun main() {
    Purchase(askAmount()).lottoNum()
    Lotto(askWinNum())
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

fun askWinNum(): List<Int> {
    try {
        println("\n" + ASK_WIN_NUM)
        return validWinNum()
    } catch (e: Exception) {
        println(WIN_NUM_ERROR)
        return askWinNum()
    }
}

fun validWinNum(): List<Int> {
    try {
        val winNum = Console.readLine().trim().split(",")
        val numbers = winNum.map { it.toInt() }
        require(numbers.size == COUNT && numbers.toSet().size == COUNT) { WIN_NUM_ERROR }
        require(numbers.all { it in START..END }) { WIN_NUM_ERROR }
        return numbers
    } catch (e: Exception) {
        throw IllegalArgumentException(WIN_NUM_ERROR)
    }
}


