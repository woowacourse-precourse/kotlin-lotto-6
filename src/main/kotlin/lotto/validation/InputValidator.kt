package lotto.validation


class InputValidator {
    private var inputLottoNumbers = mutableListOf<Int>()

    fun validateMoney(money: String): Int {
        MoneyValidation.ERROR_VALIDATION.getMessage(money)
        return money.toInt()
    }

    fun validateWinningNumber(numbers: String): List<Int> {
        WinningNumberValidation.VALIDATION_START.getMessage(numbers)
        inputLottoNumbers = numbers.split(SPLIT_STRING).map { number -> number.toInt() }.toMutableList()
        return inputLottoNumbers
    }

    fun validateBonusNumber(number: String): Int {
        BonusNumberValidation.ERROR_MESSAGE.getErrorMessage(number)
        inputLottoNumbers.add(number.toInt())
        require(inputLottoNumbers.toSet().size == CORRECT_SIZE) {
            DUPLICATION_LOTTO_NUMBER
        }
        return number.toInt()
    }

    companion object {
        private const val SPLIT_STRING = ","
        private const val DUPLICATION_LOTTO_NUMBER = "[ERROR] 당첨 번호와 보너스 번호가 중복되면 안됩니다."
        private const val CORRECT_SIZE = 7
    }
}