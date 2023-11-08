package lotto.validator

class BonusNumberValidator(winNumbers: List<Int>, bonusNumber: String) : InputValidator() {
    init {
        checkBlank(bonusNumber)
        checkForPositiveInteger(bonusNumber)
        checkForNumberRange(bonusNumber)
        checkDuplicateWithWinNumbers(winNumbers, bonusNumber.toInt())
    }

    private fun checkDuplicateWithWinNumbers(winNumbers: List<Int>, bonusNumber: Int) {
        require(!winNumbers.contains(bonusNumber)) { "[ERROR] 당첨 번호와 중복되지 않은 값을 입력해 주세요" }
    }
}
