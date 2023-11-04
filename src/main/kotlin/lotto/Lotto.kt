package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE)
        requireUnique(numbers)
    }

    private fun requireUnique(numbers: List<Int>) {
        val uniqueNumbers = numbers.toSet()
        require(uniqueNumbers.size == SIZE)
    }

    companion object {
        private const val SIZE = 6
    }
}
