package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
        require(numbers.distinct().size == numbers.size)
        require(numbers.all { it in LOTTO_RANDOM_START_NUMBER..LOTTO_RANDOM_END_NUMBER })
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun getLottoNumbers(): List<Int> = numbers

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_RANDOM_START_NUMBER = 1
        const val LOTTO_RANDOM_END_NUMBER = 45
        const val LOTTO_PRICE = 1000
    }
}
