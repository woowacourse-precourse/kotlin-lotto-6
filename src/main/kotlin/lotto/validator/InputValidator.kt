package lotto.validator

open class InputValidator {
    fun checkForValidAmount(value: String) {
        require(value.toInt() >= 1000) { "[ERROR] 최소 1,000원 이상을 입력해 주세요" }
        require((value.toInt() % 1000) == 0) { "[ERROR] 1,000원 단위로 입력해 주세요" }
    }

    fun checkForNumberRange(value: String) {

    }

    fun checkForLength(value: String) {
//        require(value.size == 6) { "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다" }
    }

    fun checkForPositiveInteger(value: String) {
        require(value.matches("^[1-9]\\d*$".toRegex())) { "[ERROR] 양의 정수를 입력해 주세요" }
    }

    fun checkForDuplicates() {

    }

    fun checkBlank(value: String) {
        require(value.isNotBlank()) { "[ERROR] 공백이 아닌 값을 입력해 주세요" }
    }
}
