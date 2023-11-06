package view

import domain.chance.Chance
import lotto.constants.Constants.RESULT_PURCHASED_LOTTIES

object ResultView {

    fun printNumberOfLottiesPurchased(chance: Chance) {
        val number = chance.getChanceTimes()
        println("$number$RESULT_PURCHASED_LOTTIES")
    }

}