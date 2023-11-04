package lotto.util

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
        val validation = input.split(",")
        validation.forEach {
            require(it.toIntOrNull() != null) { "당첨번호가 정수가 아닙니다." }
        }
    }

    fun validateLottoNotNull(input: String) {
        val validation = input.split(",")
        validation.forEach {
            require(it.trim().isNotEmpty()) { "당첨번호에 널값이 존재합니다." }
        }
    }

    fun validateLottoSpace(input: String) {
        require(!input.contains(' ')) { "당첨번호에 공백이 존재합니다." }
    }
}