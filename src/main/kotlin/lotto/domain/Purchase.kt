package lotto.domain

import lotto.util.Validator

class Purchase {
    fun payMoney(amount: String): Int {
        return Validator().validateAmount(amount)
    }

    fun calculateLottoTicketCount(amount: Int): Int {
        return amount.div(THOUSAND)
    }

    companion object {
        const val THOUSAND = 1000
    }
}