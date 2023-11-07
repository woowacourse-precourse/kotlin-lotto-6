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

class Ask {
    fun amount(): Int {
        try {
            println(ASK_AMOUNT)
            return validAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return amount()
        }
    }

    private fun validAmount(): Int {
        try {
            val cost = Console.readLine().toInt()
            require(cost % PRICE == 0 && cost >= PRICE) { AMOUNT_ERROR }
            return cost
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(AMOUNT_ERROR)
        }
    }

    fun winNum(): List<Int> {
        try {
            println(ASK_WIN_NUM)
            return validWinNum(Console.readLine())
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return winNum()
        }
    }

    fun validWinNum(input: String): List<Int> {
        try {
            val winNum = input.trim().split(",")
            val numbers = winNum.map { it.toInt() }
            require(numbers.size == COUNT && numbers.toSet().size == COUNT) { WIN_NUM_ERROR }
            require(numbers.all { it in START..END }) { WIN_NUM_ERROR }
            return numbers
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(WIN_NUM_ERROR)
        }
    }

    fun bonusNum(winNum: List<Int>): Int {
        try {
            println(ASK_BONUS_NUM)
            return validBonusNum(winNum)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return bonusNum(winNum)
        }
    }

    private fun validBonusNum(winNum: List<Int>): Int {
        try {
            val bonusNum = Console.readLine().trim().toInt()
            require(bonusNum in START..END) { BONUS_ERROR }
            require(!winNum.contains(bonusNum)) { BONUS_ERROR }
            return bonusNum
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(BONUS_ERROR)
        }
    }
}