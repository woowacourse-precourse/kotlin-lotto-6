package lotto.utils

import lotto.domain.LottoNumber
import lotto.domain.WinningLotto
import lotto.utils.Constant.BLANK_INPUT_EXCEPTION_MESSAGE
import lotto.utils.Constant.BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE
import lotto.utils.Constant.NOT_DIGIT_EXCEPTION_MESSAGE
import lotto.utils.Constant.WINNING_NUMBERS_NOT_DIGIT_MESSAGE

object ExceptionHandler {

    fun isDigit(number: String) {
        number.forEach { num ->
            require(num.isDigit()) { NOT_DIGIT_EXCEPTION_MESSAGE }
        }
    }

    fun isBlank(value: String) {
        require(value.isNotBlank()) { BLANK_INPUT_EXCEPTION_MESSAGE }
    }

    fun checkBonusNumberIsDuplicate(winningLotto: WinningLotto, bonusNumber: LottoNumber) {
        require(!winningLotto.contains(bonusNumber)) { BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE }
    }

    fun winningNumbersIsDigit(winningNumbers: String) {
        winningNumbers.forEach {
            if(it != ',' && !it.isDigit())
                throw IllegalArgumentException(WINNING_NUMBERS_NOT_DIGIT_MESSAGE)
        }
    }
}