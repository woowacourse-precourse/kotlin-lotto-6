package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WINNING_NUMBERS_SIZE)
    }

    fun toLottoNumbersResult(): String {
        return numbers.toString()
    }


    companion object {
        private const val WINNING_NUMBERS_SIZE = 6
    }
}
