package lotto.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateInteger(input: String) {
        input.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
    }
}