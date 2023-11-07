package lotto.ui

import lotto.constants.*
import lotto.domain.Lotto
import lotto.domain.Match

object Output {
    fun printLotteryNumber(lotteryNumber: Int) {
        println()
        println("${lotteryNumber}${MESSAGE_LOTTERY_NUMBER}")
    }

    fun printLottos(lottos: MutableList<Lotto>) {
        for (i in lottos.indices) {
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

    fun printWinningStatistics(winningDetails: MutableList<Int>) {
        println()
        println(MESSAGE_WINNING_STATISTICS)
        println(DIVIDING_LINE)
        println(MATCH_THREE + "${winningDetails[Match.THREE.value]}" + COUNT)
        println(MATCH_FOUR + "${winningDetails[Match.FOUR.value]}" + COUNT)
        println(MATCH_FIVE + "${winningDetails[Match.FIVE.value]}" + COUNT)
        println(MATCH_FIVE_AND_BONUS + "${winningDetails[Match.FIVE_AND_BONUS.value]}" + COUNT)
        println(MATCH_SIX + "${winningDetails[Match.SIX.value]}" + COUNT)
    }
}