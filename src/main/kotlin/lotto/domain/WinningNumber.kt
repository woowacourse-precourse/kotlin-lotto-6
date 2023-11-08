package lotto.domain


enum class WinningNumber(message: String) {
    DUPLICATE("[ERROR] 중복 되는 숫자 없이 입력해 주세요."),
    NON_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해 주세요."),
    NON_COMMA("[ERROR] 각 숫자를 쉼표(,)로 나눠주세요."),
}

// 쉼표로 나누기, 정수로 변경
fun parser(input: String): List<String> {
    val win = input.split(",")
    require(win.any { it.isBlank() }) {"쉼표로나눠"}
//    return win.map { it.toInt() }
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
    require(numericNumbers.size == numbers.size) { Number.NON_INTEGER }
    return numericNumbers
}

fun handleInvalidNumberOfNumbers(numbers: List<Int>) {
    require(numbers.size == 6) { WinningNumber.NON_SIX_NUMBER }
}

fun handleEmptyString(numbers: List<String>) {
    for(index in numbers.indices) {
        require(numbers[index].isNotEmpty() && numbers[index].isNotBlank()) { Number.EMPTY }
    }
}

fun handleDuplicateNumbers(numbers: List<Int>) {
    require(numbers.size == numbers.distinct().size) { WinningNumber.DUPLICATE }
}

fun handleInvalidRange(numbers: List<Int>) {
    val validNumbers = numbers.filter { it in 1..45 }
    require(validNumbers.size == numbers.size) { Number.INVALID_RANGE }
}

fun handleNonCommaSeparated(input: String) {
    val regex = Regex("^(?!.*,{2})[0-9,]+$")
    require(regex.matches(input)) { WinningNumber.NON_COMMA }
}