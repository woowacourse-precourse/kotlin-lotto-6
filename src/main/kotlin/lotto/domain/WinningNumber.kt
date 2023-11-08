package lotto.domain

import lotto.Constants.COUNT
import lotto.Constants.MAX_NUMBER
import lotto.Constants.MIN_NUMBER


enum class WinningNumber(val message: String) {
    DUPLICATE("[ERROR] 중복 되는 숫자 없이 입력해 주세요."),
    NON_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해 주세요."),
    NON_COMMA("[ERROR] 각 숫자를 쉼표(,)로 나눠주세요."),
    COMMA(","),
    PATTERN("^(?!.*,{2})[0-9,]+$")
}

fun parser(input: String): List<String> {
    val win = input.split(WinningNumber.COMMA.message)
    return win
}

fun winningNumberValidators(input: String): List<Int> {
    val input = parser(input)
    val numbers = handleNonInteger(input)
    handleEmptyString(input)
    handleInvalidNumberOfNumbers(numbers)
    handleDuplicateNumbers(numbers)
    handleInvalidRange(numbers)

    return numbers
}

fun handleNonInteger(numbers: List<String>): List<Int> {
    val numericNumbers = numbers.mapNotNull { it.toIntOrNull() }
    require(numericNumbers.size == numbers.size) { Number.NON_INTEGER.message }
    return numericNumbers
}

fun handleInvalidNumberOfNumbers(numbers: List<Int>) {
    require(numbers.size == COUNT) { WinningNumber.NON_SIX_NUMBER.message }
}

fun handleEmptyString(numbers: List<String>) {
    for(index in numbers.indices) {
        require(numbers[index].isNotEmpty() && numbers[index].isNotBlank()) { Number.EMPTY.message }
    }
}

fun handleDuplicateNumbers(numbers: List<Int>) {
    require(numbers.size == numbers.distinct().size) { WinningNumber.DUPLICATE.message }
}

fun handleInvalidRange(numbers: List<Int>) {
    val validNumbers = numbers.filter { it in MIN_NUMBER..MAX_NUMBER }
    require(validNumbers.size == numbers.size) { Number.INVALID_RANGE.message }
}

fun handleNonCommaSeparated(input: String) {
    val regex = Regex(WinningNumber.PATTERN.message)
    require(regex.matches(input)) { WinningNumber.NON_COMMA.message }
}