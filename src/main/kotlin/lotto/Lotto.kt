package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        validateRepeat()
    }

    fun sortNumbers(): List<Int> {
        return numbers.sorted()
    }

    private fun validateRepeat() = require(numbers.size == numbers.toSet().size)
}
