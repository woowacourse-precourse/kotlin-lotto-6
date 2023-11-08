package lotto.util

object Exception {
    fun validateTypeException(amount: String) {
        requireNotNull(amount.toIntOrNull()) { EXCEPTION_MESSAGE + WRONG_NUMBER_EXCEPTION }
    }

    fun validateNegativeException(amount: Int) {
        require(amount >= ZERO) { EXCEPTION_MESSAGE + WRONG_RANGE_NEGATIVE_EXCEPTION }
    }

    fun validateUnitException(amount: Int) {
        require(amount % LOTTO_PRICE_STANDARD == ZERO && amount > ZERO) { EXCEPTION_MESSAGE + WRONG_UNIT_EXCEPTION }
    }

    fun validationRangeException(number: Int) {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { EXCEPTION_MESSAGE + WRONG_RANGE_EXCEPTION }
    }

    fun validationDuplicationException(lotto: List<Int>, number: Int) {
        if (lotto.count { it == number } != LOTTO_BONUS_COUNT) throw IllegalArgumentException(
            DUPLICATE_NUMBER_EXCEPTION
        )
    }

    fun validationSeparatorException(number: String) {
        require(number.contains(LOTTO_NUMBER_SEPARATOR)) { EXCEPTION_MESSAGE + WRONG_SEPARATOR }
    }

    fun validationBonusCountException(bonus: String) {
        require(!bonus.contains(LOTTO_NUMBER_SEPARATOR)) { EXCEPTION_MESSAGE + WRONG_BONUS_COUNT_EXCEPTION }
    }

    fun validationBonusDuplicationException(bonus: Int, winningNumber: List<Int>) {
        require(!winningNumber.contains(bonus)) { EXCEPTION_MESSAGE + DUPLYCATE_BONUS_EXCEPTION }
    }
}