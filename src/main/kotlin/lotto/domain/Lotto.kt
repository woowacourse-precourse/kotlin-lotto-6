package lotto.domain

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_SIZE)
        require(numbers.toSet().size == LOTTO_SIZE)
        require(numbers.all { it in LOTTO_NUM_MIN..LOTTO_NUM_MAX })
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        const val LOTTO_SIZE = 1
        const val LOTTO_NUM_MIN = 1
        const val LOTTO_NUM_MAX = 45
    }
}
