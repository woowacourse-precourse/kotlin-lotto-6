package lotto.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateInteger(input: String) {
        input.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
    }

    fun validateRange(input: String) {
        require(input.toInt() in 1000..Int.MAX_VALUE) { "사용자의 입력이 유효하지 않은 범위의 숫자입니다." }
    }

    fun validate1000Unit(input: String) {
        val number = input.toInt()
        require(number % 1000 == 0) { "사용자 입력이 1000원 단위가 아닙니다." }
    }
}