package lotto.model

class WinningAmount {
    var amount: Long = 0

    fun add(addition: Int) {
        amount += addition
    }
}