package lotto.model

import java.lang.IllegalArgumentException

object Validation {

    private const val NUM_ERROR_MESSAGE = "[ERROR] 숫자만 입력 가능합니다."
    private const val DIVIDE_1000_ERROR_MESSAGE = "[ERROR] 1000원 단위로 로또 구매 가능합니다."
    private const val COMMA_ERROR_MESSAGE = "[ERROR] 쉼표(,)를 기준으로 구분해주세요"
    private const val NUM_AMOUNT_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요"
    private const val NUM_RANGE_ERROR_MESSAGE  = "[ERROR] 1에서 45 숫자만 입력 가능합니다."
    private const val MULTI_NUM_ERROR_MESSAGE = "[ERROR] 하나의 숫자만 입력 가능합니다."
    private const val UNIQUE_NUM_ERROR_MESSAGE = "[ERROR] 서로 다른 숫자를 입력해주세요."

    fun getPurchaseAmount(input: String):Int {
        checkIsDigit(input)
        checkCanDivided1000(input)
        return input.toInt()
    }

    fun getAnswerNumber(input: String):List<Int> {
        checkIsListDigit(input)
        checkContainComma(input)
        checkNumAmount(input)
        checkNumRange(input)
        checkUniqueNum(input)
        return input.split(",").map { it.toInt() }
    }

    fun getBonusNum(input: String):Int {
        checkIsDigit(input)
        checkNumRange(input)
        checkNotContainComma(input)
        return input.toInt()
    }

    private fun checkIsDigit(input: String) {
        try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(NUM_ERROR_MESSAGE)
        }
    }

    private fun checkCanDivided1000(input: String) {
        require(input.toInt() %1000==0) {
            DIVIDE_1000_ERROR_MESSAGE
        }
    }


    private fun checkIsListDigit(input:String){
        val answerNums = input.split(",")
        for(num in answerNums){
            checkIsDigit(num)
        }
    }
    private fun checkContainComma(input: String) {
        require(input.contains(",")) {
            COMMA_ERROR_MESSAGE
        }
    }

    private fun checkNumAmount(input:String){
        require(input.split(",").size==6) {
            NUM_AMOUNT_ERROR_MESSAGE
        }
    }

    private fun checkNumRange(input: String) {
        val answerNums = input.split(",").map { it.toInt() }
        for(num in answerNums){
            require(num in 1..45){
                NUM_RANGE_ERROR_MESSAGE
            }
        }
    }

    private fun checkNotContainComma(input: String){
        require(!input.contains(",")) {
            MULTI_NUM_ERROR_MESSAGE
        }
    }

    private fun checkUniqueNum(input: String){
        val answerNums = input.split(",")
        require(answerNums.toSet().size==answerNums.size){
            UNIQUE_NUM_ERROR_MESSAGE
        }
    }
}