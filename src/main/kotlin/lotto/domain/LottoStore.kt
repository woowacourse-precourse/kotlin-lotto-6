package lotto.domain

import lotto.validator.PurchasePriceValidator
import camp.nextstep.edu.missionutils.Randoms

class LottoStore(private val purchasePrice: String) {
    init {
        PurchasePriceValidator(purchasePrice)
    }

    fun sellTickets(): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        for (i in 0 until getNumberOfTickets()) {
            tickets.add(Lotto(generateNumbers()))
        }

        return tickets
    }

    fun getNumberOfTickets(): Int {
        return purchasePrice.toInt() / 1000
    }

    private fun generateNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)
        return numbers.sorted()
    }

    companion object {
        const val START_INCLUSIVE = 1
        const val END_INCLUSIVE = 9
        const val COUNT = 6
    }
}
