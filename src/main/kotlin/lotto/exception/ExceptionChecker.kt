package lotto.exception

import lotto.Const


class ExceptionChecker {

    fun checkAmount(amount: String) {
        isDigitNumber(amount)
        isEnough(amount.toInt())
        isDollarUnit(amount.toInt())
    }

    private fun isDigitNumber(amount: String) {
        if (amount == "") throw IllegalArgumentException(ERROR_LABEL + ERROR_NOT_DIGIT)
        for (character in amount) {
            if (!character.isDigit()) {
                throw IllegalArgumentException(ERROR_LABEL + ERROR_NOT_DIGIT)
            }
        }
    }

    private fun isEnough(amount: Int) {
        if (amount < Const.DOLLAR) {
            throw IllegalArgumentException(ERROR_LABEL + ERROR_NOT_ENOUGH_MONEY)
        }

    }

    private fun isDollarUnit(amount: Int) {
        if (amount % Const.DOLLAR != Const.ZERO) {
            throw IllegalArgumentException(ERROR_LABEL + ERROR_NOT_DOLLAR)
        }
    }

    fun checkWinningNumbers(numbers: List<String>) {
        isDigit(numbers)
        isValidSize(numbers)
        isDuplicate(numbers)
        isInRange(numbers.map { it.toInt() })
    }

    private fun isDigit(numbers: List<String>) {
        for (number in numbers) {
            isDigitNumber(number)
        }
    }

    private fun isValidSize(numbers: List<String>) {
        if (numbers.size != Const.LOTTO_SIZE) throw IllegalArgumentException(ERROR_LABEL + ERROR_SIZE)
    }

    private fun isDuplicate(numbers: List<String>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException(ERROR_LABEL + ERROR_DISTINCT)
        }
    }

    private fun isInRange(numbers: List<Int>) {
        for (number in numbers) {
            if (number < Const.LOTTO_MIN_NUMBER || number > Const.LOTTO_MAX_NUMBER) throw IllegalArgumentException(ERROR_LABEL + ERROR_RANGE)
        }
    }

    private fun isInRange(number: Int) {
        if (number < Const.LOTTO_MIN_NUMBER || number > Const.LOTTO_MAX_NUMBER) throw IllegalArgumentException(ERROR_LABEL + ERROR_RANGE)

    }

    fun checkBonusNumber(winningNumbers: List<Int>, bonusNumber: String) {
        isDigitNumber(bonusNumber)
        isDuplicate(winningNumbers, bonusNumber.toInt())
        isInRange(bonusNumber.toInt())
    }

    private fun isDuplicate(winningNumbers: List<Int>, bonusNumber: Int) {
        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException(ERROR_LABEL + ERROR_DISTINCT)
    }

    companion object {
        const val ERROR_LABEL = "[ERROR] "
        const val ERROR_DISTINCT = "중복된 수가 존재합니다."
        const val ERROR_RANGE = "1부터 45 사이의 수를 입력해주세요"
        const val ERROR_SIZE = "6개의 숫자를 입력해주세요"
        const val ERROR_NOT_DOLLAR = "1000원 단위의 금액을 입력해주세요."
        const val ERROR_NOT_ENOUGH_MONEY = "금액이 부족합니다."
        const val ERROR_NOT_DIGIT = "숫자가 아닙니다."
    }


}