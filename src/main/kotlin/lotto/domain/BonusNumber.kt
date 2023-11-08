package lotto.domain

enum class BonusNumber(number: String) {
    SINGLE_NUMBER("[ERROR] 1개의 숫자를 입력해 주세요."),
}

fun BonusNumberValidators(input: String): Int {
    handleInvalidNumber(input)
    val bonus = handleNonInteger(input)
    handleInvalidRange(bonus)
    return bonus
}

private fun handleInvalidNumber(input: String) {
    require(input.length == 1) { BonusNumber.SINGLE_NUMBER }
}

private fun handleNonInteger(input: String): Int {
    val numericNumber = input.toIntOrNull()
    require(numericNumber != null) { Number.NON_INTEGER }
    return numericNumber
}

private fun handleInvalidRange(number: Int) {
    require(number in 1..45 ) { Number.INVALID_RANGE }
}