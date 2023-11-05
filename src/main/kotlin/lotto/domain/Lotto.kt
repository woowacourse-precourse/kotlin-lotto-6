package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun sort(): List<Int> {
        return numbers.sorted()
    }
}