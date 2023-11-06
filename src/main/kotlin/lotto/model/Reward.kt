package lotto.model

import kotlin.math.roundToLong

class Reward(map: Map<Int, Int>, count: Int) {
    val rateOfReturn: Double
    val mapping = mapOf(
        3 to 5000L,
        4 to 50000L,
        50 to 1500000L, 51 to 30000000L,
        6 to 2000000000L,
    )

    init {
        val Amount = map.map {
            mapping.getValue(it.key) * it.value
        }.sumOf { it }

        rateOfReturn = (Amount * 10000 / count).toDouble()
            .roundToLong() / 100.toDouble()
    }
}