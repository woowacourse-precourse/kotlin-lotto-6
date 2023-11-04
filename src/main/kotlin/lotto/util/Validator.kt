package lotto.util

object Validator {
    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) { Exception.INVALID_INTEGER.getMessage() }
    }

    fun validateRange(input: String) {
        require(input.toInt() in 1000..Int.MAX_VALUE) { Exception.INVALID_RANGE.getMessage() }
    }

    fun validate1000Unit(input: String) {
        val number = input.toInt()
        require(number % 1000 == 0) { Exception.INVALID_1000_UNIT.getMessage() }
    }

    fun validateLottoInteger(input: String) {
        val validation = input.chunked(1)
        validation.forEach {
            require(it.toIntOrNull() != null) { "당첨번호가 정수가 아닙니다." }
        }
    }
}