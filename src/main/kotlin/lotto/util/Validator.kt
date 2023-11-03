package lotto.util

/*
- 1 이상의 정수인지
- 1000원으로 나누어 떨어지는지
- 공백이 아닌지
*/
private const val ERROR_CONVENTION = "[ERROR] "
private const val NOT_INTEGER_MSG = "입력 값은 정수여야 합니다."
private const val NOT_NEGATIVE_INTEGER_MSG = "입력 값은 0보다 큰 정수여야 합니다."

private const val POSITIVE_NUM = 1

private const val NOT_EMPTY_MSG = "입력 값은 공백이 될 수 없습니다."

object Validator {
     fun isItInteger(input: String) {
        val value = input.toIntOrNull()
        require(value != null) {ERROR_CONVENTION + NOT_INTEGER_MSG }
    }
    fun isItPositive(input: Int){
       require(input>= POSITIVE_NUM){ERROR_CONVENTION + NOT_NEGATIVE_INTEGER_MSG }
    }
    fun isItNotEmpty(input: String){
        require(input.trim().isNotEmpty()){ERROR_CONVENTION + NOT_EMPTY_MSG }
    }
}