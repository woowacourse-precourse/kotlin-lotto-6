package lotto

fun isValidInteger(digits: String): Boolean {
    return digits.all { it.isDigit() }
}

fun isPriceMultipleOf1000(value: Int): Boolean {
    return value % 1000 == 0
}

