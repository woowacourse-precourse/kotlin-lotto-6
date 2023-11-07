package lotto

object LottoMath {
    fun roundRate(doubleNumber: Double): Double {
        val scaledNumber = (doubleNumber * 100).toInt()
        val remainder = scaledNumber % 10
        return if (remainder >= 5) {
            ((scaledNumber + 10) / 100).toDouble()
        } else {
            (scaledNumber / 100).toDouble()
        }
    }
}