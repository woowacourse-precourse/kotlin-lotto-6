package domain.lotto

class Lotto(private val numbers: List<Int>) {

    private lateinit var sortedNumbers: List<Int>

    init {
        require(numbers.size == 6)
        sortRandomNumbers()
    }

    private fun sortRandomNumbers() {
        sortedNumbers = numbers.sorted()
    }

    fun getSortedNumbers() = sortedNumbers
}
