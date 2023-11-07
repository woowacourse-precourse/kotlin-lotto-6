package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.ASK_AMOUNT
import lotto.Constants.ASK_BONUS_NUM
import lotto.Constants.ASK_WIN_NUM
import lotto.Constants.BONUS_ERROR
import lotto.Constants.COUNT
import lotto.Constants.END
import lotto.Constants.PRICE
import lotto.Constants.START
import lotto.Constants.WIN_NUM_ERROR

fun main() {
    try {
        val amount = askAmount()
        val number = Purchase(amount).lottoNum()
        val winNum = askWinNum()
        val bonusNum = askBonusNum(winNum)
        val winStat = mutableListOf<Int>(0, 0, 0, 0, 0, 0)
        number.map { winStat[Lotto(it).isWin(winNum, bonusNum)]++ }
        Statistics(winStat).stat(amount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

fun askAmount(): Int {
    try {
        println(ASK_AMOUNT)
        return validAmount()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return askAmount()
    }
}

fun validAmount(): Int {
    try {
        val cost = Console.readLine().toInt()
        require(cost % PRICE == 0 && cost >= PRICE) { AMOUNT_ERROR }
        return cost
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException(AMOUNT_ERROR)
    }
}

fun askWinNum(): List<Int> {
    try {
        println("\n" + ASK_WIN_NUM)
        return validWinNum()
    } catch (e: IllegalArgumentException) {
        println(e.message)
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
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException(WIN_NUM_ERROR)
    }
}

fun askBonusNum(winNum: List<Int>): Int {
    try {
        println("\n" + ASK_BONUS_NUM)
        return validBonusNum(winNum)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return askBonusNum(winNum)
    }
}

fun validBonusNum(winNum: List<Int>): Int {
    try {
        val bonusNum = Console.readLine().trim().toInt()
        require(bonusNum in START..END) { BONUS_ERROR }
        require(!winNum.contains(bonusNum)) { BONUS_ERROR }
        return bonusNum
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException(BONUS_ERROR)
    }
}


