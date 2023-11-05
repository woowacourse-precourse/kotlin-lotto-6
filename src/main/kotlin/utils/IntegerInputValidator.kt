package utils

open class IntegerInputValidator {

    open fun validateIsString(input: String) {
        requireNotNull(input.toIntOrNull()) { INPUT_STRING_ERR_MSG }
    }

    open fun validateIsNegative(input: String) {
        require(input.toInt() > -1) { INPUT_NEGATIVE_ERR_MSG }
    }

    open fun validateIsZero(input: String) {
        require(input.toInt() != 0) { INPUT_ZERO_ERR_MSG }
    }

    companion object {
        const val INPUT_STRING_ERR_MSG = "숫자를 입력해주세요."
        const val INPUT_NEGATIVE_ERR_MSG = "음수 값이 올 수 없습니다."
        const val INPUT_ZERO_ERR_MSG = "1000 이상의 값을 입력해주세요."
    }
}