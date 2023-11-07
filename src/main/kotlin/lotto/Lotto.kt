package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun lottoNumberToString() = numbers.joinToString(prefix = "[", postfix = "]", separator = ",")

}
