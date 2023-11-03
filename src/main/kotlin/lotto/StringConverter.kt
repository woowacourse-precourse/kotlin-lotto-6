package lotto

fun Int.convertWithDigitComma() = "%,d".format(this)

fun Double.convertWithRound() = "%.1f".format(this)