package lotto.ui

import lotto.constants.*

object Output {
    fun printLotteryNumber(lotteryNumber: Int) {
        println()
        println("${lotteryNumber}${MESSAGE_LOTTERY_NUMBER}")
    }
}