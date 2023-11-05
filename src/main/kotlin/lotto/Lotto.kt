package lotto
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { MessageConstants.ERROR_NOT_6_NUMBERS }
        validateLottoNumbers(numbers)
    }
    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_START_NUM = 1
        const val LOTTO_END_NUM = 45
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(MessageConstants.ERROR_DUPLICATE_NUMBER)
        }

        if (numbers.any { it < LOTTO_START_NUM || it > LOTTO_END_NUM }) {
            throw IllegalArgumentException(MessageConstants.ERROR_LESS_THAN_1_OR_MORE_THAN_45)
        }
    }
}
