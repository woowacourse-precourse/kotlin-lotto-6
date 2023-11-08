package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_SIZE)
        require(numbers.toSet().size == LOTTO_SIZE)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
