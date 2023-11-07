package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.ALLOWED_ATTEMPTS_EXCEEDED
import lotto.Constants.AMOUNT_ERROR
import lotto.Constants.ASK_AMOUNT
import lotto.Constants.ASK_BONUS_NUM
import lotto.Constants.ASK_WIN_NUM
import lotto.Constants.BONUS_ERROR
import lotto.Constants.COUNT
import lotto.Constants.END
import lotto.Constants.MAX_ATTEMPT
import lotto.Constants.PRICE
import lotto.Constants.START
import lotto.Constants.WIN_NUM_ERROR

fun main() {
    try {
        val amount = askAmount(MAX_ATTEMPT)
        val number = Purchase(amount).lottoNum()
        val winNum = askWinNum(MAX_ATTEMPT)
        val bonusNum = askBonusNum(winNum, MAX_ATTEMPT)
        val winStat = mutableListOf<Int>(0, 0, 0, 0, 0, 0)
        number.map { winStat[Lotto(it).isWin(winNum, bonusNum)]++ }
        Statistics(winStat).stat(amount)
    } catch (e: Exception) {
        println(e.message)
    }
}

fun askAmount(chance: Int): Int {
    try {
        println(ASK_AMOUNT)
        return validAmount()
    } catch (e: Exception) {
        if (chance > 1) {
            println(e.message)
            return askAmount(chance - 1)
        }
        return throw IllegalArgumentException(ALLOWED_ATTEMPTS_EXCEEDED)
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

fun askWinNum(chance: Int): List<Int> {
    try {
        println("\n" + ASK_WIN_NUM)
        return validWinNum()
    } catch (e: IllegalArgumentException) {
        if (chance > 1) {
            println(e.message)
            return askWinNum(chance - 1)
        }
        return throw IllegalArgumentException(ALLOWED_ATTEMPTS_EXCEEDED)
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

fun askBonusNum(winNum: List<Int>, chance: Int): Int {
    try {
        println("\n" + ASK_BONUS_NUM)
        return validBonusNum(winNum)
    } catch (e: IllegalArgumentException) {
        if (chance > 1) {
            println(e.message)
            return askBonusNum(winNum, chance - 1)
        }
        return throw IllegalArgumentException(ALLOWED_ATTEMPTS_EXCEEDED)
    }
}

fun validBonusNum(winNum: List<Int>): Int {
    try {
        val bonusNum = Console.readLine().trim().toInt()
        require(bonusNum in START..END) { BONUS_ERROR }
        require(!winNum.contains(bonusNum)) { BONUS_ERROR }
        return bonusNum
    } catch (e: Exception) {
        throw IllegalArgumentException(BONUS_ERROR)
    }
}


