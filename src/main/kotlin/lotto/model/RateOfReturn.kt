package lotto.model

import lotto.util.Match
import kotlin.math.roundToLong

class RateOfReturn(val data: Map<Int, Int>, val count: Int) {

    fun get(): Double {
        val Amount = data.map {
            Match.getAmountForCount(it.key) * it.value
        }.sumOf { it }

        return (Amount * 10000 / count).toDouble()
            .roundToLong() / 100.toDouble()
    }
}