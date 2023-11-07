package lotto.ui

import lotto.constants.*
import lotto.domain.Lotto

object Output {
    fun printLotteryNumber(lotteryNumber: Int) {
        println()
        println("${lotteryNumber}${MESSAGE_LOTTERY_NUMBER}")
    }

    fun printLottos(lottos: MutableList<Lotto>) {
        for(i in lottos.indices){
            println(lottos[i].getLotto())
        }
    }

    fun printWinningNumbers() {
        println()
        println(MESSAGE_INPUT_WINNING_NUMBER)
    }

    fun printBonusNumbers() {
        println()
        println(MESSAGE_INPUT_BONUS_NUMBER)
    }
}