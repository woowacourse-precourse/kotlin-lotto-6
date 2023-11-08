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
    private const val LOTTO_PRICE = 1000
    private const val NUMBER_SEPARATOR = ","
    private const val LOTTO_START_NUM = 1
    private const val LOTTO_END_NUM = 45

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
        return input.split(NUMBER_SEPARATOR).map { it.toInt() }
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
        require(input.toInt() % LOTTO_PRICE==0) {
            DIVIDE_1000_ERROR_MESSAGE
        }
    }


    private fun checkIsListDigit(input:String){
        val answerNums = input.split(NUMBER_SEPARATOR)
        for(num in answerNums){
            checkIsDigit(num)
        }
    }
    private fun checkContainComma(input: String) {
        require(input.contains(NUMBER_SEPARATOR)) {
            COMMA_ERROR_MESSAGE
        }
    }

    private fun checkNumAmount(input:String){
        require(input.split(NUMBER_SEPARATOR).size==6) {
            NUM_AMOUNT_ERROR_MESSAGE
        }
    }

    private fun checkNumRange(input: String) {
        val answerNums = input.split(NUMBER_SEPARATOR).map { it.toInt() }
        for(num in answerNums){
            require(num in LOTTO_START_NUM..LOTTO_END_NUM){
                NUM_RANGE_ERROR_MESSAGE
            }
        }
    }

    private fun checkNotContainComma(input: String){
        require(!input.contains(NUMBER_SEPARATOR)) {
            MULTI_NUM_ERROR_MESSAGE
        }
    }

    private fun checkUniqueNum(input: String){
        val answerNums = input.split(NUMBER_SEPARATOR)
        require(answerNums.toSet().size==answerNums.size){
            UNIQUE_NUM_ERROR_MESSAGE
        }
    }
}