package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNumbers() = numbers
    fun lottoNumberToString() = numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ")

}
