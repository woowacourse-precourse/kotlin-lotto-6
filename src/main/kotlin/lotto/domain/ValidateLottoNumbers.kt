package lotto.domain

import java.lang.IllegalArgumentException

class ValidateLottoNumbers {

    fun validateWinningNumbers(inputWinningNumbers: String) : List<Int> {
        val winningNumbers = inputWinningNumbers.split(",")
        return validateWinningNumbersContainsEmpty(winningNumbers)
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>) : Int {
        return validateBonusNumberInWinningNumbers(validateBonusNumberContainsEmpty(bonusNumber), winningNumbers)
    }

    fun validateWinningNumbersContainsEmpty(winningNumbers: List<String>) : List<Int> {
        for (lottoNumber in winningNumbers) {
            if (lottoNumber.contains(" ")) throw IllegalArgumentException(INPUT_CONTAINS_EMPTY_ERROR_MESSAGE)
        }
        return validateWinningNumbersString(winningNumbers)
    }

    fun validateWinningNumbersString(winningNumbers: List<String>) : List<Int> {
        for (lottoNumber in winningNumbers) {
            lottoNumber.forEach { char ->
                if (char.code > ASCII_NINE_CODE || char.code < ASCII_ZERO_CODE) throw IllegalArgumentException(INPUT_STRING_ERROR_MESSAGE)
            }
        }
        return validateWinningNumberInRange(winningNumbers.map { it.toInt() })
    }

    fun validateWinningNumberInRange(winningNumbers: List<Int>) : List<Int> {
        for (winningNumber in winningNumbers) {
            if (winningNumber < RANDOM_START_RANGE_NUMBER || winningNumber > RANDOM_END_RANGE_NUMBER)
                throw IllegalArgumentException(INPUT_NOT_IN_RANGE_ERROR_MESSAGE)
        }
        return validateWinningNumberDuplicateNumber(winningNumbers)
    }

    fun validateWinningNumberDuplicateNumber(winningNumbers: List<Int>) : List<Int> {
        if (winningNumbers.distinct().size != LOTTO_NUMBER_COUNT) throw IllegalArgumentException(INPUT_WINNING_NUMBER_CONTAINS_DUPLICATE_NUMBER_ERROR_MESSAGE)
        return winningNumbers
    }

    fun validateBonusNumberContainsEmpty(bonusNumber: String) : Int{
        if (bonusNumber.isEmpty()) throw IllegalArgumentException(INPUT_CONTAINS_EMPTY_ERROR_MESSAGE)
        return validateBonusNumberString(bonusNumber)
    }

    fun validateBonusNumberString(bonusNumber: String) : Int{
        bonusNumber.forEach { char ->
            if (char.code > ASCII_NINE_CODE || char.code < ASCII_ZERO_CODE) throw IllegalArgumentException(INPUT_STRING_ERROR_MESSAGE)
        }
        return validateBonusNumberInRange(bonusNumber.toInt())
    }

    fun validateBonusNumberInRange(bonusNumber: Int) : Int{
        if (bonusNumber < RANDOM_START_RANGE_NUMBER || bonusNumber > RANDOM_END_RANGE_NUMBER)
            throw IllegalArgumentException(INPUT_NOT_IN_RANGE_ERROR_MESSAGE)
        return bonusNumber
    }

    fun validateBonusNumberInWinningNumbers(bonusNumber: Int, winningNumbers: List<Int>) : Int {
        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException(INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS_ERROR_MESSAGE)
        return bonusNumber
    }

    companion object {
        const val RANDOM_START_RANGE_NUMBER = 1
        const val RANDOM_END_RANGE_NUMBER = 45
        const val ASCII_ZERO_CODE = 48
        const val ASCII_NINE_CODE = 57
        const val LOTTO_NUMBER_COUNT = 6
        const val INPUT_CONTAINS_EMPTY_ERROR_MESSAGE = "[ERROR] 입력한 값에 공백이 포함되어 있습니다."
        const val INPUT_STRING_ERROR_MESSAGE = "[ERROR] 입력한 값에 문자가 포함되어 있습니다."
        const val INPUT_NOT_IN_RANGE_ERROR_MESSAGE = "[ERROR] 1에서 45 사이의 자연수 값이 아닌 값이 포함되어 있습니다."
        const val INPUT_WINNING_NUMBER_CONTAINS_DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 값이 있습니다."
        const val INPUT_BONUS_NUMBER_IN_WINNING_NUMBERS_ERROR_MESSAGE = "[ERROR] 입력한 보너스 번호는 이미 당첨 번호에 존재합니다."
    }
}