package lotto.exception

class BonusValidation(private val lotto: List<Int>, private val bonus: String) {

    init {
        validateBonusRange()
        validateBonusNumber()
        validateBonusDuplicate()
    }

    private fun validateBonusRange() {
        require(bonus.toInt() in 1..45) {
            ErrorConstants.INVALID_LOTTO_RANGE_ERROR
        }
    }

    private fun validateBonusNumber() {
        try {
            bonus.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorConstants.INVALID_PRICE_FORMAT_ERROR)
        }
    }

    private fun validateBonusDuplicate() {
        repeat(lotto.size) {
            require(lotto[it] != bonus.toInt()) {
                ErrorConstants.DUPLICATE_LOTTO_ERROR
            }
        }
    }
}