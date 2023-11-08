package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.domain.Lotto

class LottoNumberDispenser() {

    fun buyTickets(money: Int): MutableList<Lotto> {
        val tickets = mutableListOf<Lotto>()
        val ticketQuantity = money / 1000
        repeat(ticketQuantity) {
            tickets.add(createLottoTicket())
        }
        return tickets
    }

    private fun createLottoTicket(): Lotto {
        val nums = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(nums)
    }
}