package lotto

import java.lang.IllegalArgumentException

object Validation {

    private const val NUM_ERROR_MESSAGE = "숫자만 입력 가능합니다."
    private const val DIVIDE_1000_ERROR_MESSAGE = "1000원 단위로 로또 구매 가능합니다."
    private const val COMMA_ERROR_MESSAGE = "쉼표(,)를 기준으로 구분해주세요"

    fun purchaseAmount(input: String) {
        checkIsDigit(input)
        checkCanDivided1000(input)
    }

    fun answerNumber(input: String) {
        checkIsDigit(input)
    }

    private fun checkIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NUM_ERROR_MESSAGE)
        }
    }

    private fun checkCanDivided1000(input: String) {
        require(input.toInt() < 1000) {
            DIVIDE_1000_ERROR_MESSAGE
        }
    }


    fun bonusNum() {

    }
}