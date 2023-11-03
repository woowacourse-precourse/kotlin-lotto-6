package lotto.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateInteger(input: String) {
        input.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
    }

    fun validateRange(input: String) {
        require(input.toInt() in 1000..Int.MAX_VALUE){ "사용자의 입력이 유효하지 않은 범위의 숫자입니다." }
    }
}