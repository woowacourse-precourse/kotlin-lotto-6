package lotto.util

import lotto.controller.LottoProgram.Companion.LOTTO_PURCHASE_COST

const val ERROR_CONVENTION = "[ERROR] "
private const val NOT_INTEGER_MSG = "입력 값은 정수여야 합니다."
private const val NOT_NEGATIVE_INTEGER_MSG = "입력 값은 0보다 큰 정수여야 합니다."
private const val NOT_DIVISIBLE_MSG = "입력 값은 천 원 단위여야 합니다."
private const val NOT_EMPTY_MSG = "입력 값은 공백이 될 수 없습니다."

private const val POSITIVE_NUM = 1

object Validator {
     private fun isItInteger(input: String) {
        val value = input.toIntOrNull()
        require(value != null) {ERROR_CONVENTION + NOT_INTEGER_MSG }
    }
    private fun isItPositive(input: Int){
       require(input>= POSITIVE_NUM){ERROR_CONVENTION + NOT_NEGATIVE_INTEGER_MSG }
    }
    private fun isItNotEmpty(input: String){
        require(input.trim().isNotEmpty()){ERROR_CONVENTION + NOT_EMPTY_MSG }
    }
    private fun isDivisibleByThousand(input: Int) {
        require(input % LOTTO_PURCHASE_COST ==0){ERROR_CONVENTION + NOT_DIVISIBLE_MSG}
    }
    fun isValidPurchaseAmount(input: String){
        isItInteger(input)
        isItNotEmpty(input)
        isItPositive(input.toInt())
        isDivisibleByThousand(input.toInt())
    }


}