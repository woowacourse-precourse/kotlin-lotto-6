package model

import util.InputValidation
import util.LottoValidation

class WinningNumbersManager(private val numbers: List<String>) {

    private lateinit var winningNumbers: List<Int>
    init {
        numbers.forEach { InputValidation.ONLY_NUMBER.isValid(it) }
        numbers.forEach { InputValidation.NUMBER_FORMAT.isValid(it) }
        winningNumbers = numbers.map { it.toInt() }
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(winningNumbers)
    }
}
