package lotto.validator

import lotto.constant.Constants.WIN_NUMBERS_LENGTH

class WinNumbersValidator(winNumbers: List<String>) : InputValidator() {
    init {
        winNumbers.forEach {
            checkBlank(it)
            checkForPositiveInteger(it)
            checkForNumberRange(it)
        }
        checkForWinNumbersLength(winNumbers)
        checkDuplicateForWinNumbers(winNumbers)
    }

    private fun checkForWinNumbersLength(winNumbers: List<String>) {
        require(winNumbers.size == WIN_NUMBERS_LENGTH) { "[ERROR] 당첨 번호는 6개가 필요합니다" }
    }

    private fun checkDuplicateForWinNumbers(winNumbers: List<String>) {
        require(winNumbers.size == winNumbers.toSet().size) { "[ERROR] 중복된 값이 존재합니다" }
    }
}
