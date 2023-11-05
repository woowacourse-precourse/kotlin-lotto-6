package lotto

import util.Constants.MONEY_FIFTH_PRIZE
import util.Constants.MONEY_FOURTH_PRIZE
import util.Constants.MONEY_JACKPOT
import util.Constants.MONEY_SECOND_PRIZE
import util.Constants.MONEY_THIRD_PRIZE

enum class LottoPrize(val value: Int, var count: Int, val prizeMoney: Long) {
    FIFTH_PRIZE(3, 0, 5_000){
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_FIFTH_PRIZE}) - ${count}개")
    },
    FOURTH_PRIZE(4, 0, 50_000){
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_FOURTH_PRIZE}) - ${count}개")
    },
    THIRD_PRIZE(5, 0, 1_500_000){
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_THIRD_PRIZE}) - ${count}개")
    },
    SECOND_PRIZE(5, 0, 30_000_000){
        override fun printPrizeData() =
            println("${value}개 일치, 보너스 볼 일치 (${MONEY_SECOND_PRIZE}) - ${count}개")
    },
    JACKPOT(6, 0, 2_000_000_000) {
        override fun printPrizeData() =
            println("${value}개 일치 (${MONEY_JACKPOT}) - ${count}개")
    };
    abstract fun printPrizeData()

    fun calculatePrizeMoney(): Long = count * prizeMoney
}