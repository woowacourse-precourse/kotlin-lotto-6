package lotto.validator

import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.MAX_ATTEMPTS
import lotto.constant.Constants.START_INCLUSIVE

open class InputValidator {
    fun checkBlank(value: String) {
        require(value.isNotBlank()) { "[ERROR] 공백을 제외한 값을 입력해 주세요" }
    }

    fun checkForPositiveInteger(value: String) {
        require(value.matches("^[0-9]\\d*$".toRegex())) { "[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요" }
    }

    fun checkForNumberRange(value: String) {
        val number = value.toInt()
        require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다" }
    }

    fun <T> inputWithRetry(prompt: () -> T, validator: (value: T) -> Unit): T {
        repeat(MAX_ATTEMPTS) {
            try {
                val value = prompt().also { println() }
                validator(value)
                return value
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }
}
