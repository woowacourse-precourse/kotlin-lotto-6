package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
