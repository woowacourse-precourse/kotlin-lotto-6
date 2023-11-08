package lotto.model

import lotto.util.GameConstants.PERCENT
import lotto.util.GameConstants.VALUE_1ST
import lotto.util.GameConstants.VALUE_2ND
import lotto.util.GameConstants.VALUE_3RD
import lotto.util.GameConstants.VALUE_4TH
import lotto.util.GameConstants.VALUE_5TH

class Prize(private val ranking: List<Int>, private val amount: Int) {
    private val _rate: String

    val rate: String
        get() = _rate

    init {
        _rate = getRate(ranking, amount)
    }

    private fun getPrize(ranking: List<Int>): Int {
        return ranking[0] * VALUE_1ST + ranking[1] * VALUE_2ND +
                ranking[2] * VALUE_3RD + ranking[3] * VALUE_4TH +
                ranking[4] * VALUE_5TH
    }

    private fun getRate(ranking: List<Int>, amount: Int): String {
        val prize = getPrize(ranking)
        val rate = (prize.toDouble() / amount.toDouble()) * PERCENT
        return String.format("%.1f", rate)
    }
}