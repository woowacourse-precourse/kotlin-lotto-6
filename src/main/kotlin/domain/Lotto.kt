package domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_COUNT)
        require(numbers.distinct().size == LOTTO_COUNT)
    }

    fun getSortedNumbers() = numbers.sorted()

    companion object {
        private const val LOTTO_COUNT = 6
    }
}
