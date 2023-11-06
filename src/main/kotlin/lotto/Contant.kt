package lotto

const val DIVIDE_MONEY_NUMBER = 1000
const val MAX_LOTTO_SIZE = 6
const val MAX_LOTTO_RANGE = 45
const val MIN_LOTTO_RANGE = 1
fun errorMessageFormat(errorMessage: String): String {
    return "[ERROR] %s".format(errorMessage)
}