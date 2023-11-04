package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}