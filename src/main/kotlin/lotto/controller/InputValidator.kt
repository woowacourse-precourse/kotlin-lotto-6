package lotto.controller

import lotto.util.ExceptionPrinter.executeSafelyAndPrintException

class InputValidator {
    fun validatePurchaseAmount(input: Int): Boolean {
        return executeSafelyAndPrintException {
            require(input > 0 && input % 1000 == 0) {
                INVALID_PURCHASE_AMOUNT
            }
        }
    }

    fun validateLottoNumbers(numbers: List<Int>): Boolean {
        var isValid = validateLottoNumberCount(numbers)
        if (isValid) {
            numbers.forEach {
                isValid = validateNumber(it)
            }
        }
        return isValid
    }

    fun validateBonusNumber(bonusNumber: Int, numbers: List<Int>): Boolean {
        var isValid = validateNumber(bonusNumber)
        if (isValid) {
            isValid = validateDuplicate(bonusNumber, numbers)
        }
        return isValid
    }

    internal fun validateNumber(number: Int): Boolean {
        return executeSafelyAndPrintException {
            require(number in (1..45)) {
                INVALID_LOTTO_NUMBER
            }
        }
    }

    internal fun validateDuplicate(bonusNumber: Int, numbers: List<Int>): Boolean {
        return executeSafelyAndPrintException {
            require(!numbers.contains(bonusNumber)) {
                INVALID_DUPLICATE_NUMBER
            }
        }
    }

    private fun validateLottoNumberCount(numbers: List<Int?>): Boolean {
        return executeSafelyAndPrintException {
            require(numbers.size == 6) {
                INVALID_LOTTO_NUMBERS_COUNT
            }
        }
    }

    companion object {
        const val INVALID_PURCHASE_AMOUNT = "[ERROR] 구입할 금액은 1,000 원 단위 숫자여야 합니다."
        const val INVALID_LOTTO_NUMBERS_COUNT = "[ERROR] 로또 번호는 6자리여야 합니다."
        const val INVALID_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val INVALID_DUPLICATE_NUMBER = "[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다."
    }
}