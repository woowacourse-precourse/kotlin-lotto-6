package lotto.validator

import lotto.Constants.NUMBER_END_RANGE
import lotto.Constants.NUMBER_START_RANGE

class BonusNumberValidator {
    fun validate(inputBonusNumber: String, winningNumbers: List<Int>) {
        val bonusNumber = parseToInt(inputBonusNumber)
        requireValidNumberRange(bonusNumber)
        requireUniqueNumber(bonusNumber, winningNumbers)
    }

    private fun parseToInt(inputBonusNumber: String): Int {
        return try {
            inputBonusNumber.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_BONUS_NUMBER_FORMAT_ERROR_MESSAGE)
        }
    }

    private fun requireValidNumberRange(bonusNumber: Int) {
        require(bonusNumber in NUMBER_START_RANGE..NUMBER_END_RANGE) { BONUS_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE }
    }

    private fun requireUniqueNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber)) { DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val INVALID_BONUS_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val BONUS_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.."
        private const val DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."
    }
}