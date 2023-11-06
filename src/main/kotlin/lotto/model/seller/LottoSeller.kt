package lotto.model.seller

import lotto.model.PaymentAmount

class LottoSeller {

    private val lottoGenerator = LottoGenerator.createWithRandomGenerator()

    fun issueLottoTicket(moneyInput: String): Ticket {
        val paymentAmount = PaymentAmount.from(moneyInput)
        return lottoGenerator.createLottos(count = paymentAmount.purchase)
    }
}