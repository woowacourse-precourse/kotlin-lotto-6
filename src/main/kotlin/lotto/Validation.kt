package lotto

object Validation {

    fun validateOutOfRange(amount: String): Long {
        val num = amount.toLongOrNull() ?: throw IllegalArgumentException(Messages.EXCEPTION_WRONG_FORMAT.message)
        require(num in 1000..4_611_686_018_000) { Messages.EXCEPTION_WRONG_RANGE.message }
        return num
    }

    fun validateMoneyUnit(num: Long) {
        require(num % 1000L == 0L) { Messages.EXCEPTION_WRONG_MONEY_UNIT.message }
    }

    fun validateDuplicateNumber(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { Messages.EXCEPTION_DUPLICATE_NUMBER.message }
    }

    fun validateLottoNumber(str: String): Int {
        val num = str.trim().toIntOrNull() ?: throw IllegalArgumentException(Messages.EXCEPTION_WRONG_FORMAT.message)
        require(num in 1..45) { Messages.EXCEPTION_WRONG_RANGE_NUMBER.message }
        return num
    }

    fun validateWrongLengthNumber(numbers: List<Int>) {
        require(numbers.size == 6) { Messages.EXCEPTION_WRONG_LENGTH_NUMBER.message }
    }

    fun validateDuplicateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonusNumber)) { Messages.EXCEPTION_DUPLICATE_NUMBER.message }
    }
}