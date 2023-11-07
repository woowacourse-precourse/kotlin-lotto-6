package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    override fun toString(): String {
        val sortedNumbers = numbers.sorted()
        return sortedNumbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    }
}
