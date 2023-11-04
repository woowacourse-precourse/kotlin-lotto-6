package lotto

class Purchase(private val amount: Int) {
    init {
        require(amount % AMOUNT_UNIT_WON == 0)
    }

    companion object {
        private const val AMOUNT_UNIT_WON = 1000
    }
}
