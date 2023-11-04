package lotto.util

import lotto.controller.LottoProgram.Companion.LOTTO_PURCHASE_COST
import lotto.model.LottoPublisher.Companion.ZERO_NUM
import lotto.model.LottoPublisher.Companion.LOTTO_RANGE_END
import lotto.model.LottoPublisher.Companion.LOTTO_RANGE_START
import lotto.model.LottoPublisher.Companion.LOTTO_SIZE

const val ERROR_CONVENTION = "[ERROR] "
private const val NOT_INTEGER_MSG = "입력 값은 정수여야 합니다."
private const val NOT_POSITIVE_INTEGER_MSG = "입력 값은 0보다 큰 정수여야 합니다."
private const val NOT_DIVISIBLE_MSG = "입력 값은 천 원 단위여야 합니다."
private const val NOT_EMPTY_MSG = "입력 값은 공백이 될 수 없습니다."
private const val NOT_IN_RANGE_MSG = "입력 값은 1부터 45 사이의 정수로 구성되어야 합니다."
private const val NOT_UNIQUE_NUMS_MSG = "입력 값은 중복된 값이 존재하면 안됩니다."
private const val INVALID_SIZE_MSG =  "사이즈는 %d이어야 합니다."
private const val ALREADY_EXIST_MSG =  "이미 존재하는 숫자입니다."

private const val POSITIVE_NUM = 1

 const val DELIMITER = ','

object Validator {
    private fun isItInteger(input: String) {
        val value = input.toIntOrNull()
        require(value != null) { ERROR_CONVENTION + NOT_INTEGER_MSG }
    }

    private fun isItPositive(input: Int) {
        require(input >= POSITIVE_NUM) { ERROR_CONVENTION + NOT_POSITIVE_INTEGER_MSG }
    }

    private fun isItNotEmpty(input: String) {
        require(input.trim().isNotEmpty()) { ERROR_CONVENTION + NOT_EMPTY_MSG }
    }

    private fun isDivisibleByThousand(input: Int) {
        require(input % LOTTO_PURCHASE_COST == ZERO_NUM) { ERROR_CONVENTION + NOT_DIVISIBLE_MSG }
    }

    private fun isNumInRange(input: Int) {
        require(input in LOTTO_RANGE_START..LOTTO_RANGE_END) { ERROR_CONVENTION + NOT_IN_RANGE_MSG }
    }

    private fun isNumsDuplicated(input: List<String>) {
        require(input.size == input.toSet().size) { ERROR_CONVENTION + INVALID_SIZE_MSG }
    }

    private fun isProperSize(input:List<String>) {
        require(input.size == LOTTO_SIZE){ ERROR_CONVENTION + INVALID_SIZE_MSG.format(LOTTO_SIZE) }
    }
    private fun isNumExist(input: Int,winningNums: List<Int>){
        require(!winningNums.contains(input)){ ERROR_CONVENTION + ALREADY_EXIST_MSG}
    }

    fun isValidPurchaseAmount(input: String) {
        isItNotEmpty(input)
        isItInteger(input)
        isItPositive(input.toInt())
        isDivisibleByThousand(input.toInt())
    }

    fun isValidWinningNums(input: String) {
        val userInput = input.split(DELIMITER)
        userInput.forEach {
            isItNotEmpty(it)
            isItInteger(it)
            isItPositive(it.toInt())
            isNumInRange(it.toInt())
        }
        isNumsDuplicated(userInput)
        isProperSize(userInput)
    }

    fun isValidBonusNum(input: String,winningNums:List<Int>){
        isItNotEmpty(input)
        isItInteger(input)
        isNumInRange(input.toInt())
        isNumExist(input.toInt(),winningNums)
    }
}