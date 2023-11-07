package lotto.validator

class BonusNumberValidator(winNumbers: List<Int>, bonusNumber: String) : InputValidator() {
    init {
        checkBlank(bonusNumber)
        checkForPositiveInteger(bonusNumber)
        checkForNumberRange(bonusNumber)
        checkDuplicateWithWinNumbers(winNumbers, bonusNumber.toInt())
    }
}
