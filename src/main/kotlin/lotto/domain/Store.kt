package lotto.domain

import lotto.data.Lotto

class Store(
    private val io: IO,
    private val pos: PointOfSales,
) {
    fun buyLotto(): List<Lotto> {
        val chargeAmount: UInt = io.getPurchaseAmount()
        val (quantity, change) = pos.getQuotientAndRemainder(chargeAmount, LOTTO_PRICE)

        require(change == NO_CHANGE) {
            SHOULD_BE_NO_CHANGE.format(LOTTO_PRICE.toLong())
        }
        return pos.issueLotto(quantity).apply {
            io.showIssuedLotto(this)
        }
    }

    fun checkWinningLotto(tickets: List<Lotto>) {
        val stats = pos.checkResultOfLotto(tickets)

        io.showStats(stats)
    }

    companion object {
        const val LOTTO_PRICE = 1_000u
        const val SHOULD_BE_NO_CHANGE = "[ERROR] %d원 단위로 지불하셔야 합니다."
        private const val NO_CHANGE = 0
    }
}