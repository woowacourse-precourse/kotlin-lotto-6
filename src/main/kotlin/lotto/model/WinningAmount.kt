package lotto.model

class WinningAmount {
    var totalAmount: Long = 0

    fun add(additionalValue: Int) {
        totalAmount += additionalValue
    }
}