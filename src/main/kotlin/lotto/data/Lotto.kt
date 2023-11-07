package lotto.data

import lotto.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_LOTTO_NUMBER_COUNT_MESSAGE }
        require(!numbers.map { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }.contains(false)) {
            Constants.ERROR_LOTTO_NUMBER_BOUNDARY_MESSAGE
        }
        require(numbers.distinct().size == numbers.size) { Constants.ERROR_LOTTO_NUMBER_DISTINCTION_MESSAGE }
    }

    fun getNumbers() = this.numbers
}