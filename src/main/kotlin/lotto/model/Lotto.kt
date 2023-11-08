package lotto.model

import lotto.utils.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        checkNumbersValidate()
    }

    private fun checkNumbersValidate() {
        numbers.forEach { number ->
            require(number in lottoRange) { Constants.LOTTO_NUMBER_RANGE_ERROR_MESSAGE }
        }
        require(numbers.size == 6) { Constants.LOTTO_NUMBER_SIZE_ERROR_MESSAGE }
        require(numbers.size == numbers.toSet().size) { Constants.LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE }
    }

    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.filter { it in winningNumbers }.size
    }

    fun isMatchNumber(number: Int): Boolean = numbers.contains(number)

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    companion object {
        val lottoRange = Constants.MIN_LOTTO_NUMBER_RANGE..Constants.MAX_LOTTO_NUMBER_RANGE
    }
}