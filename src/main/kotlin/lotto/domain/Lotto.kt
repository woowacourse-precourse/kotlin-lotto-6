package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_SIZE)
        require(numbers.toSet().size == NUMBER_SIZE)
    }

    fun sort(): List<Int> {
        return numbers.sorted()
    }

    companion object {
        const val NUMBER_SIZE = 6
    }
}