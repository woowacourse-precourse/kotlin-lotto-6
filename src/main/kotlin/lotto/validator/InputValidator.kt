package lotto.validator

import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.START_INCLUSIVE

open class InputValidator {
    fun checkForPositiveInteger(value: String) {
        require(value.matches("^[0-9]\\d*$".toRegex())) { "[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요" }
    }

    fun checkBlank(value: String) {
        require(value.isNotBlank()) { "[ERROR] 공백을 제외한 값을 입력해 주세요" }
    }

    fun checkForNumberRange(value: String) {
        val number = value.toInt()
        require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다" }
    }
}
