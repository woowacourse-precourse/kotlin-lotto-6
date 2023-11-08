package lotto.utils

import kotlin.math.roundToInt

object Extensions {
    fun Int.withCommas(): String {
        return "%,d".format(this)
    }

    fun Double.roundTo2DecimalPlaces(): Double {
        return (this * 100.0).roundToInt() / 100.0
    }
}