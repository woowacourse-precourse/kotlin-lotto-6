package lotto.Model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoTicket {
    fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
        val numberOfTickets = purchaseAmount / 1000
        val lottoTickets = mutableListOf<Lotto>()

        repeat(numberOfTickets) {
            val lottoTicket = generateSingleLottoTicket()
            lottoTickets.add(lottoTicket)
        }

        return lottoTickets
    }

    fun generateSingleLottoTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}
