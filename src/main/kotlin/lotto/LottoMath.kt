package lotto

object LottoMath {
    fun roundRate(doubleNumber: Double): Double {
        val scaledNumber = (doubleNumber * 100).toInt()
        val remainder = scaledNumber % 10
        println("${(scaledNumber / 100)} , $remainder")
        return if (remainder >= 5) {
            (((scaledNumber - remainder).toDouble() + 10) / 100)
        } else {
            ((scaledNumber - remainder).toDouble() / 100)
        }
    }
}