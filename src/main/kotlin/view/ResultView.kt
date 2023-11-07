package view

import domain.chance.Chance
import domain.result.FinalResult
import domain.result.Rank
import lotto.constants.Constants.PRIZE_SEPARATOR
import lotto.constants.Constants.RESULT_FINAL_STAT
import lotto.constants.Constants.RESULT_NUM_UNIT
import lotto.constants.Constants.RESULT_PURCHASED_LOTTIES
import lotto.constants.Constants.RESULT_SEPARATOR
import lotto.constants.Constants.RESULT_TOTAL_RATING_COMPLEMENT
import lotto.constants.Constants.RESULT_TOTAL_RATING_SUBJECT

class ResultView {

    fun printNumberOfLottiesPurchased(chance: Chance) {
        val number = chance.getChanceTimes()
        println("$number$RESULT_PURCHASED_LOTTIES")
    }

    fun printPurchasedLotties(lotties: MutableList<MutableList<Int>>) {
        lotties.onEach { numbers ->
            println(numbers)
        }
        println()
    }

    fun printFinalResult(finalResult: FinalResult) {
        println(RESULT_FINAL_STAT)
        println(RESULT_SEPARATOR)
        printWinningStats(finalResult.winningData)
        printReturnRate(finalResult.rateOfReturn)
    }

    private fun printWinningStats(winningData: Map<Rank, Int>) {
        winningData.onEach { (rank, count) ->
            println("${rank.reward} $PRIZE_SEPARATOR $count$RESULT_NUM_UNIT")
        }
    }

    private fun printReturnRate(rate: String) {
        println("$RESULT_TOTAL_RATING_SUBJECT $rate$RESULT_TOTAL_RATING_COMPLEMENT")
    }
}