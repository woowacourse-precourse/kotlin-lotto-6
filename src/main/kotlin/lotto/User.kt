package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    private var _amount = 0
    val amount get() = _amount

    private var _winningNumbers = mutableListOf<Int>()
    val winningNumbers get() = _winningNumbers.sorted().toList()

    private var _bonusNumber = 0
    val bonusNumber get() = _bonusNumber

    fun inputAmount() {
        val input = Console.readLine()
        setAmountFromInput(input.trim())
    }

    private fun setAmountFromInput(input: String) {
        require(isValidAmount(input)) { INVALID_AMOUNT_ERROR_MESSAGE }
        _amount = input.toInt()
    }

    private fun isValidAmount(input: String) =
        isNotEmpty(input) && isInputDigitsOnly(input) && isAmountInUnit(input.toInt())

    private fun isAmountInUnit(amount: Int) = amount >= AMOUNT_UNIT && amount % AMOUNT_UNIT == 0

    fun inputWinningNumbers() {
        val input = Console.readLine()
        setWinningNumbers(input.split(SEPARATOR))
    }

    private fun setWinningNumbers(inputs: List<String>) {
        val trimmedInputs = inputs.map { it.trim() }
        trimmedInputs.forEach {
            require(isValidInputNumber(it)) { INVALID_NUMBER_ERROR_MESSAGE }
        }

        val numbers = trimmedInputs.map { it.toInt() }
        require(isValidWinningNumberCount(numbers)) { INVALID_WINNING_NUMBER_COUNT_ERROR_MESSAGE }
        require(isValidRangeNumbers(numbers)) { INVALID_RANGE_NUMBER_ERROR_MESSAGE }
        require(isValidDistinctNumber(numbers)) { INVALID_DISTINCT_NUMBER_ERROR_MESSAGE }

        _winningNumbers.addAll(numbers)
    }

    fun inputBonusNumber() {
        val input = Console.readLine()
        setBonusNumber(input.trim())
    }

    private fun setBonusNumber(input: String) {
        require(isValidInputNumber(input)) { INVALID_NUMBER_ERROR_MESSAGE }
        require(isValidRangeNumber(input.toInt())) { INVALID_RANGE_NUMBER_ERROR_MESSAGE }
    }


    private fun isNotEmpty(input: String) = input.isNotEmpty()

    private fun isInputDigitsOnly(input: String) = input.all { it.isDigit() }

    private fun isValidInputNumber(input: String) = isNotEmpty(input) && isInputDigitsOnly(input)

    private fun isValidWinningNumberCount(numbers: List<Int>) = numbers.size == WINNING_NUMBER_COUNT

    private fun isValidRangeNumbers(numbers: List<Int>) = numbers.all { isValidRangeNumber(it) }

    private fun isValidRangeNumber(number: Int) = number in Lotto.MIN_NUMBER..Lotto.MAX_NUMBER

    private fun isValidDistinctNumber(numbers: List<Int>) = numbers.size == numbers.distinct().size


    companion object {
        const val AMOUNT_UNIT = 1000
        const val INVALID_AMOUNT_ERROR_MESSAGE = "금액은 $AMOUNT_UNIT 단위의 숫자만 입력이 가능합니다."

        const val SEPARATOR = ","
        const val INVALID_NUMBER_ERROR_MESSAGE = "번호는 숫자로 입력해야 합니다."

        const val WINNING_NUMBER_COUNT = 6
        const val INVALID_WINNING_NUMBER_COUNT_ERROR_MESSAGE = "당첨 번호의 개수가 ${WINNING_NUMBER_COUNT}개가 아닙니다."

        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val INVALID_RANGE_NUMBER_ERROR_MESSAGE = "번호의 범위가 ${MIN_NUMBER}이상 ${MAX_NUMBER}이하가 아닙니다."

        const val INVALID_DISTINCT_NUMBER_ERROR_MESSAGE = "중복된 번호가 있습니다."
    }
}