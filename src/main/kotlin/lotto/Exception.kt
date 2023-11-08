package lotto

import lotto.utils.Strings

object Exception {

    fun purchaseAmountEntryException(input: String?): Int? {
        if (input.isNullOrEmpty() || !input.all { it.isDigit() }) {
            throw IllegalArgumentException(Strings.EXCEPTION_COMMON)
        }
        val amount = input.toInt()
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(Strings.EXCEPTION_PURCHASE_AMOUNT)
        }
        return amount
    }

    fun enterWinningNumberException(input: String?): List<Int> {
        try {
            val numbers = input?.split(",")?.map { it.trim().toInt() }
            if (numbers != null && numbers.size == 6 && numbers.all { it in 1..45 } && numbers.toSet().size == numbers.size) {
                return numbers
            } else {
                throw IllegalArgumentException(Strings.EXCEPTION_WINNING_NUMBER)
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Strings.EXCEPTION_NUMBER)
        }
    }

    fun enterBonusNumberException(input: String?, winningNumbers: List<Int>): Int {
        val number = input?.toIntOrNull()
        if (number != null && number in 1..45 && number !in winningNumbers) {
            return number
        } else {
            throw IllegalArgumentException(Strings.EXCEPTION_OVERLAP)
        }
    }

}