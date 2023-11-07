package lotto

object Validator {
    val MIN_RANGE = 1
    val MAX_RANGE = 45
    val LOTTO_PRICE = 1000
    val MAX_LOTTO_LENGTH = 6

    fun validateBonusNumber(input: String): Int {
        val bonusNumber = convertToNumber(input)
        isAvailableRange(bonusNumber)

        return bonusNumber
    }

    fun validateBudget(input: String): Int {
        val budget = convertToNumber(input)
        isAvailableUnit(budget)

        return budget
    }

    fun validateNumbers(input: List<Int>): List<Int> {
        isAvailableLength(input.size)
        isDuplicatedNumber(input)
        input.map {
            isAvailableRange(it)
        }
        return input
    }

    fun isDuplicatedNumber(input: List<Int>): Boolean {
        require(input.distinct().size == MAX_LOTTO_LENGTH) {
            ErrorCode.DUPLICATE_ERROR.message
        }
        return true
    }

    fun mapToWinningNumbers(input: String): List<Int> {
        val list = input.split(',').map {
            convertToNumber(it)
        }

        return list
    }

    fun convertToNumber(input: String): Int {
        var result: Int
        try {
            result = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorCode.NOT_NUMBER_ERROR.message)
        }

        return result
    }

    fun isAvailableRange(input: Int): Boolean {
        require(input in MIN_RANGE..MAX_RANGE) {
            ErrorCode.NUMBER_RANGE_ERROR.message
        }

        return true
    }

    fun isAvailableUnit(input: Int): Boolean {
        require(input % LOTTO_PRICE == 0) {
            ErrorCode.MONEY_UNIT_ERROR.message
        }

        return true
    }

    fun isAvailableLength(size: Int): Boolean {
        require(size == MAX_LOTTO_LENGTH) {
            ErrorCode.LENGTH_ERROR.message
        }

        return true
    }
}