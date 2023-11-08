package lotto


fun parseLottoPrice(input: String): Int {
    return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.PRICE_NOT_INT)
}

fun parseNormalWinningNumbers(input: String): List<Int> {
    val numbers = input.split(",").map { it.trim() }
    if (numbers.any { it.toIntOrNull() == null }) {
        throw IllegalArgumentException(ErrorMessages.NORMAL_NUMBER_NOT_INT)
    }
    return numbers.map { it.toInt() }
}

fun parseBonusNumber(input: String): Int {
    return input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.BONUS_NUMBER_NOT_INT)
}