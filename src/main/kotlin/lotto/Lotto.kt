package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBERS)
        require(numbers.distinct().size == LOTTO_NUMBERS)
    }

    fun getLottoNumber(): List<Int> {
        return numbers.sorted()
    }

    companion object {
        const val LOTTO_NUMBERS = 6
    }
}
