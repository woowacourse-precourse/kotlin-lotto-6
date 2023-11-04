package lotto

fun calculateRateOfReturn(totalPrize: Int, amount: Int): Double {
    return totalPrize.toDouble() / amount * 100
}

fun roundDigit (number : Double, digits : Int): Double {
    return Math. round (number * Math.pow(10.0, digits.toDouble())) / Math.pow(10.0, digits.toDouble())
}