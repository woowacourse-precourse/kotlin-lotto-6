package lotto.model.validation

import lotto.Constants

data class LottoNumber(private val inputdata: String) {
    init {
        val inputNumber = inputdata.toIntOrNull()

        validateDigit(inputNumber)
        validateRange(inputNumber)
    }

    private fun validateDigit(inputNumber: Int?) {
        requireNotNull(inputNumber) {
            LOTTO_NUMBER_NOT_DIGIT
        }
    }

    private fun validateRange(inputNumber: Int?) {
        require(inputNumber in Constants.LOTTO_RANGE) {
            LOTTO_NUMBER_OUT_OF_RANGE
        }
    }

    companion object {
        const val LOTTO_NUMBER_NOT_DIGIT = "로또 번호는 숫자여야 합니다."
        const val LOTTO_NUMBER_OUT_OF_RANGE =
            "로또 번호는 ${Constants.LOTTO_RANGE_MIN_VALUE}부터 ${Constants.LOTTO_RANGE_MAX_VALUE} 사이의 숫자여야 합니다."


    }

    override fun toString(): String {
        return "$inputdata"
    }
}