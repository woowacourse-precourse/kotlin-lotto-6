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
}