package lotto.validator

import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.START_INCLUSIVE

open class InputValidator {
    fun checkForValidAmount(value: String) {
        require(value.toInt() >= 1000) { "[ERROR] 최소 1,000원 이상을 입력해 주세요" }
        require((value.toInt() % 1000) == 0) { "[ERROR] 1,000원 단위로 입력해 주세요" }
    }

    fun checkForPositiveInteger(value: String) {
        require(value.matches("^[1-9]\\d*$".toRegex())) { "[ERROR] 양의 정수를 입력해 주세요" }
    }

    fun checkForDuplicates(winNumbers: List<String>) {
        require(winNumbers.size == winNumbers.toSet().size) { "[ERROR] 중복된 값이 존재합니다" }
    }

    fun checkBlank(value: String) {
        require(value.isNotBlank()) { "[ERROR] 공백과 문자를 제외한 값을 입력해 주세요" }
    }

    fun checkForNumberRange(value: String) {
        val number = value.toInt()
        require(number in START_INCLUSIVE..END_INCLUSIVE) { "[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다" }
    }

    fun checkForWinNumbersLength(winNumbers: List<String>) {
        require(winNumbers.size == 6) { "[ERROR] 당첨 번호는 6개가 필요합니다" }
    }

    fun checkForBonusNumberLength(bonusNumber: String) {
        require(bonusNumber.toInt() == 1) { "[ERROR] 보너스 번호는 하나만 입력해 주세요" }
    }
}
