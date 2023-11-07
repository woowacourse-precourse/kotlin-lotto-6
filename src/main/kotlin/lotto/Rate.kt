package lotto

import kotlin.math.round

class Rate(
    private val num: Int,
    private val denum: Int,
    private val decimalPoint: Int,
) {
    private val rate = num.toDouble() / denum.toDouble()
    private val roundRate = round(rate * decimalPoint) / decimalPoint
    init {
        require(denum > 0)
    }
    override fun toString(): String = "$roundRate%"
}
