package lotto

object Validator {
    val MIN_RANGE = 1
    val MAX_RANGE = 45
    val LOTTO_PRICE = 1000
    val MAX_LOTTO_LENGTH = 6
    val MAX_COUNT_OF_NUMBER_IN_LOTTO = 1

    fun isAvailableRange(input: Int): Boolean {
        require(MIN_RANGE <= input && MAX_RANGE >= input) {
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

    fun convertToNumber(input: String): Int {
        var result = 0
        try {
            result = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorCode.NOT_NUMBER_ERROR.message)
        }

        return result
    }

    fun validateBonusNumber(input: String): Int {
        val bonusNumber = convertToNumber(input)
        isAvailableRange(bonusNumber)

        return bonusNumber
    }

    fun validateBudget(input: String): Int {
        var budget = 0
        try {
            budget = input.toInt()
            isAvailableUnit(budget)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorCode.NOT_NUMBER_ERROR.message)
        }

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

    fun mapToWinningNumbers(input: String): List<Int> {
        val list = input.split(',').map {
            convertToNumber(it)
        }

        return list
    }

    fun isDuplicatedNumber(input: List<Int>): Boolean {
        var countNumber: MutableList<Int> = mutableListOf(0)
        val MIN = input.min()
        val MAX = input.max()
        for (i in MIN..MAX) {
            countNumber.add(0)
        }

        input.map {
            val index = it + (1 - MIN)
            countNumber[index] += 1
            require(countNumber[index] <= MAX_COUNT_OF_NUMBER_IN_LOTTO) { ErrorCode.DUPLICATE_ERROR.message }
        }

        return true
    }
    
}