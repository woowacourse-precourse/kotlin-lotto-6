package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_SIZE)
        require(numbers.toSet().size == NUMBER_SIZE)
        require(numbers.all { it in START_NUMBER..END_NUMBER })
    }

    fun sort(): List<Int> = numbers.sorted()

    companion object {
        const val NUMBER_SIZE = 6
        const val START_NUMBER = 1
        const val END_NUMBER = 45
    }
}