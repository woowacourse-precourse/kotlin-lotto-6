package lotto.model.seller

import lotto.model.PaymentAmount

class LottoSeller {

    private val lottoGenerator = LottoGenerator.createWithRandomGenerator()

    fun issueLottoTicket(moneyInput: String): Ticket {
        val payment = PaymentAmount.from(moneyInput, LOTTO_PRICE)
        return lottoGenerator.createLottos(count = paymentAmount.purchase)
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}