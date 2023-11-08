package lotto.domain

import lotto.domain.validator.LottoManagerValidator.validateBonusNumberInput
import lotto.domain.validator.LottoManagerValidator.validateNoDuplicateNumbers
import lotto.domain.validator.LottoManagerValidator.validateWinningNumbersInput

class LottoManager {

    lateinit var winningNumbers: List<Int>
        private set

    var bonusNumber: Int? = null
        private set

    fun setWinningNumbers(input: String) {
        validateWinningNumbersInput(input)
        winningNumbers = input.split(",").map {
            it.trim().toInt()
        }
    }

    fun setBonusNumber(input: String) {
        validateBonusNumberInput(input)
        validateNoDuplicateNumbers(winningNumbers, input)
        bonusNumber = input.toInt()
    }
}