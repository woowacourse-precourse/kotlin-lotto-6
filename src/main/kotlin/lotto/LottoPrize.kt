package lotto

import util.Constants.MONEY_FIFTH_PRIZE
import util.Constants.MONEY_FOURTH_PRIZE
import util.Constants.MONEY_JACKPOT
import util.Constants.MONEY_SECOND_PRIZE
import util.Constants.MONEY_THIRD_PRIZE

enum class LottoPrize(val value: Int, var count: Int) {
    JACKPOT(6, 0) {
        override fun printPrizeData() =
            println("${JACKPOT.value}개 일치 (${MONEY_JACKPOT}) - ${JACKPOT.count}개")
    },
    SECOND_PRIZE(5, 0){
        override fun printPrizeData() =
            println("${SECOND_PRIZE.value}개 일치, 보너스 볼 일치 (${MONEY_SECOND_PRIZE}) - ${SECOND_PRIZE.count}개")
    },
    THIRD_PRIZE(5, 0){
        override fun printPrizeData() =
            println("${THIRD_PRIZE.value}개 일치 (${MONEY_THIRD_PRIZE}) - ${THIRD_PRIZE.count}개")
    },
    FOURTH_PRIZE(4, 0){
        override fun printPrizeData() =
            println("${FOURTH_PRIZE.value}개 일치 (${MONEY_FOURTH_PRIZE}) - ${FOURTH_PRIZE.count}개")
    },
    FIFTH_PRIZE(3, 0){
        override fun printPrizeData() =
            println("${FIFTH_PRIZE.value}개 일치 (${MONEY_FIFTH_PRIZE}) - ${FIFTH_PRIZE.count}개")
    };

    abstract fun printPrizeData()
}