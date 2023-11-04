package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE)
        require(numbers.isUnique())
        requireInRange(numbers)
    }

    private fun requireInRange(numbers: List<Int>) {
        numbers.forEach { number ->
            require(number in NUMBER_RANGE)
        }
    }

    companion object {
        private const val SIZE = 6
        private val NUMBER_RANGE = 1..45
    }
}
