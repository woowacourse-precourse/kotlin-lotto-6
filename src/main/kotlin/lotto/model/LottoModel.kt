package lotto.model

class LottoModel {
    fun isPurchaseAmountNumeric(input: String): Boolean {
        try {
            val numeric = input.toInt()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }

    fun isPurchaseAmountPositive(value: Int): Boolean {
        return value > 0
    }

}