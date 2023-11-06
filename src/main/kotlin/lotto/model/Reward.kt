package lotto.model

import kotlin.math.roundToLong

class Reward(map: Map<Int, Int>, count: Int) {
    val rateOfReturn: Double

    init {
        val Amount = map.map {
            Match.getAmountForCount(it.key) * it.value
        }.sumOf { it }

        rateOfReturn = (Amount * 10000 / count).toDouble()
            .roundToLong() / 100.toDouble()
    }
}