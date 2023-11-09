package lotto.domain

import lotto.domain.util.Validator

class Purchase {
    private val validator = Validator()

    fun payMoney(amount: String): Int = validator.amount(amount)

    fun calculateLottoTicketCount(amount: Int): Int = amount.div(THOUSAND)

    companion object {
        const val THOUSAND = 1000
    }
}