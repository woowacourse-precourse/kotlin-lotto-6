package model

import util.InputValidation
import util.LottoValidation

class WinningNumbersManager(private val numbers: List<String>) {

    private lateinit var winningNumbers: List<Int>
    private var bonusNumber = 0

    init {
        numbers.forEach {
            InputValidation.NUMBER_EMPTY.isValid(it)
            InputValidation.ONLY_NUMBER.isValid(it)
            InputValidation.NUMBER_FORMAT.isValid(it)
        }
        winningNumbers = numbers.map { it.toInt() }
        LottoValidation.REQUIRED_LOTTO_NUMBER_COUNT.isValid(winningNumbers)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(winningNumbers)
    }

    fun isBonusNumberValid(number: String) {
        require(!winningNumbers.contains(number.toInt())) { "[ERROR] 당첨 번호에 포함된 번호는 보너스 번호로 지정할 수 없습니다." }
    }
}
