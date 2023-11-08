package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.domain.Lotto
import lotto.util.Constants.LOTTO_NUMBER_SIZE
import lotto.util.Constants.LOTTO_TICKET_PRICE
import lotto.util.Constants.MAXIMUM_LOTTO_NUMBER
import lotto.util.Constants.MINIMUM_LOTTO_NUMBER

class LottoNumberDispenser() {

    fun buyTickets(money: Int): MutableList<Lotto> {
        val tickets = mutableListOf<Lotto>()
        val ticketQuantity = money / LOTTO_TICKET_PRICE
        repeat(ticketQuantity) {
            tickets.add(createLottoTicket())
        }
        return tickets
    }

    private fun createLottoTicket(): Lotto {
        val nums = Randoms.pickUniqueNumbersInRange(
            MINIMUM_LOTTO_NUMBER,
            MAXIMUM_LOTTO_NUMBER,
            LOTTO_NUMBER_SIZE
        )
        return Lotto(nums)
    }
}