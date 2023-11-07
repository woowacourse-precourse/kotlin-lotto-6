package lotto

import java.lang.IllegalArgumentException

object Validation {

    private const val NUM_ERROR_MESSAGE = "숫자만 입력 가능합니다."
    private const val DIVIDE_1000_ERROR_MESSAGE = "1000원 단위로 로또 구매 가능합니다."
    private const val COMMA_ERROR_MESSAGE = "쉼표(,)를 기준으로 구분해주세요"
    private const val NUM_AMOUNT_ERROR_MESSAGE = "6개의 숫자를 입력해주세요"
    private const val NUM_RANGE_ERROR_MESSAGE  = "1에서 45 숫자만 입력 가능합니다."

    fun purchaseAmount(input: String) {
        checkIsDigit(input)
        checkCanDivided1000(input)
    }

    fun answerNumber(input: String) {
        checkIsDigit(input)
        checkContainComma(input)
        checkNumAmount(input)
        checkNumRange(input)
    }

    fun bonusNum(input: String) {
        checkIsDigit(input)
        checkNumRange(input)
        checkNotContainComma(input)
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

    private fun checkContainComma(input: String) {
        require(!input.contains(",")) {
            COMMA_ERROR_MESSAGE
        }
    }

    private fun checkNumAmount(input:String){
        require(input.split(",").size!=6) {
            NUM_AMOUNT_ERROR_MESSAGE
        }
    }

    private fun checkNumRange(input: String) {
        val answerNums = input.split(",").map { it.toInt() }
        for(num in answerNums){
            require(num !in 1..45){
                NUM_RANGE_ERROR_MESSAGE
            }
        }
    }

    private fun checkNotContainComma(input: String){
        require(input.contains(",")) {
            COMMA_ERROR_MESSAGE
        }
    }
}