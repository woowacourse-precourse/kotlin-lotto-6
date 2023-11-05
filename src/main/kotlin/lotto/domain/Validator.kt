package lotto.domain

class Validator {
    fun checkInputOfPurchasingCorrect(input: String) {
        requireNotNull(input.toUIntOrNull()) {
            SHOULD_BE_POSITIVE_NUM
        }
    }

    companion object {
        private const val SHOULD_BE_POSITIVE_NUM = "[ERROR] 0보다 큰 숫자를 입력해주세요."
    }
}