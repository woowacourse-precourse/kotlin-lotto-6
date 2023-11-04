package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}