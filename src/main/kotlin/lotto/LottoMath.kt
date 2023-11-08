package lotto

object LottoMath {
    fun roundRate(doubleNumber: Double): Double {
        val scaledNumber = (doubleNumber * 100).toInt()
        val remainder = scaledNumber % 10
        println("${(scaledNumber / 100)} , $remainder")
        if (remainder >= 5) {
            return ((scaledNumber - remainder).toDouble() + 10) / 100
        }
        return (scaledNumber - remainder).toDouble() / 100
    }
}