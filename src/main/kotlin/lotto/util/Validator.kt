package lotto.util

/*
- 1 이상의 정수인지
- 1000원으로 나누어 떨어지는지
- 공백이 아닌지
*/
private const val ERROR_CONVENTION = "[ERROR] "
private const val NOT_INTEGER_MSG = "입력 값은 정수여야 합니다."

object Validator {
     fun isItInteger(input: String) {
        val value = input.toIntOrNull()
        require(value != null) { ERROR_CONVENTION + NOT_INTEGER_MSG }
    }
}