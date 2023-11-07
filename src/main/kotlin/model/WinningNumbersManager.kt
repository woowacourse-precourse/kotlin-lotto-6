package model

import util.InputValidation
import util.LottoValidation

class WinningNumbersManager(numbers: List<String>) {

    private var winningNumbers: List<Int>
    private var bonusNumber = 0

    init {
        numbers.forEach {
            InputValidation.NUMBER_EMPTY.isValid(it)
            InputValidation.ONLY_NUMBER.isValid(it)
            InputValidation.NUMBER_FORMAT.isValid(it)
            InputValidation.NUMBER_RANGE.isValid(it)
        }
        winningNumbers = numbers.map { it.toInt() }
        LottoValidation.REQUIRED_LOTTO_NUMBER_COUNT.isValid(winningNumbers)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(winningNumbers)
    }

    fun isBonusNumberValid(number: String) {
        InputValidation.NUMBER_EMPTY.isValid(number)
        InputValidation.ONLY_NUMBER.isValid(number)
        InputValidation.NUMBER_FORMAT.isValid(number)
        InputValidation.NUMBER_RANGE.isValid(number)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers.plus(number.toInt()))
    }

    fun setBonusNumber(number: String) {
        bonusNumber = number.toInt()
    }

    fun getRank(numbers: List<Int>): Int {
        when (winningNumbers.count { numbers.contains(it) }) {
            3 -> return 5
            4 -> return 4
            5 -> {
                if (numbers.contains(bonusNumber)) return 2
                return 3
            }

            6 -> return 1
        }
        return 0
    }

}
