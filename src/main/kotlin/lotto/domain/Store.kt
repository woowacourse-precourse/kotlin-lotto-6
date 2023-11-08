package lotto.domain

import lotto.data.Lotto

class Store(
    private val io: IO,
    private val calculator: Calculator,
    private val pos: PointOfSales,
) {

    fun buyLotto(): List<Lotto> {
        val purchaseAmount: UInt = io.getPurchaseAmount()
        val (quantity, change) = calculator.getQuotientAndRemainder(purchaseAmount, Lotto.PRICE.toUInt())

        require(change == NO_CHANGE) {
            SHOULD_BE_NO_CHANGE.format(Lotto.PRICE)
        }
        return pos.issueLotto(quantity).apply {
            io.showIssuedLotto(this)
        }
    }

    fun checkResult(tickets: List<Lotto>) {
        val stats = pos.checkResult(tickets)

        io.showStats(stats)
    }

    companion object {
        const val SHOULD_BE_NO_CHANGE = "[ERROR] %d원 단위로 지불하셔야 합니다."
        private const val NO_CHANGE = 0
    }
}