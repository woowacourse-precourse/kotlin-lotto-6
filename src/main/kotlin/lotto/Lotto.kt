package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6) { ExceptionMessage.NOT_DUPLICATED_NUMBER }
        require(numbers.all { it in 1..45 }) { ExceptionMessage.NOT_LOTTO_NUMBER_IN_RANGE }
    }

    fun getNumbers() = numbers
    fun lottoNumberToString() = numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ")

}
