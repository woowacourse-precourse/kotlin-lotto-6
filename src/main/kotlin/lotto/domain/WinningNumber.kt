package lotto.domain


enum class WinningNumber(number: String) {
    EMPTY("[ERROR] 당첨 번호를 공백 없이 입력해 주세요."),
    DUPLICATE("[ERROR] 중복 되는 숫자 없이 입력해 주세요."),
    NON_SIX_NUMBER("[ERROR] 6개의 숫자를 입력해 주세요."),
    NON_INTEGER("[ERROR] 정수만 입력해 주세요."),
    NON_COMMA("[ERROR] 각 숫자를 쉼표(,)로 나눠주세요."),
    INVALID_RANGE("[ERROR] 1 ~ 45 사이의 정수만 입력해 주세요.")
}

// 쉼표로 나누기, 정수로 변경
fun parser(input: String): List<String> {
    val win = input.split(",")
    require(win.any { it.isBlank() }) {"쉼표로나눠"}
//    return win.map { it.toInt() }
    return win
}

fun winningNumberValidators(input: String) {
    val input = parser(input)
    val numbers = handleNonInteger(input)
    handleEmptyString(input)
    handleInvalidNumberOfNumbers(numbers)
    handleDuplicateNumbers(numbers)
    handleInvalidRange(numbers)
}

fun handleNonInteger(numbers: List<String>): List<Int> {
    val numericNumbers = numbers.mapNotNull { it.toIntOrNull() }
    require(numericNumbers.size == numbers.size) { WinningNumber.NON_INTEGER }
    return numericNumbers
}

fun handleInvalidNumberOfNumbers(numbers: List<Int>) {
    require(numbers.size == 6) { WinningNumber.NON_SIX_NUMBER }
}

fun handleEmptyString(numbers: List<String>) {
    for(index in numbers.indices) {
        require(!numbers[index].isNullOrBlank()) { WinningNumber.EMPTY }
    }
}

fun handleDuplicateNumbers(numbers: List<Int>) {
    require(numbers.size == numbers.distinct().size) { WinningNumber.DUPLICATE }
}

fun handleInvalidRange(numbers: List<Int>) {
    val validNumbers = numbers.filter { it in 1..45 }
    require(validNumbers.size == numbers.size) { WinningNumber.INVALID_RANGE }
}

fun handleNonCommaSeparated(input: String) {
    val regex = Regex("^(?!.*,{2})[0-9,]+$")
    require(regex.matches(input)) { WinningNumber.NON_COMMA }
}