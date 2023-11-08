package lotto.domain

import lotto.model.Winning

class Calculator {

    fun calculateYield(amount: Int, reward: HashMap<Winning, Int>): String {

        return "%.1f".format(addTotalEarnings(reward).toDouble() / amount.toDouble() * 100)
    }

    fun addTotalEarnings(reward: HashMap<Winning, Int>): Int {

        var totalWinning = 0

        for ((winning, count) in reward) {
            totalWinning += winning.reward * count
        }
        return totalWinning
    }
}