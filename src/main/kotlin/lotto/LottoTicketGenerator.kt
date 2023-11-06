package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoTicketGenerator {
    fun createAutoTicket() = Lotto(
        Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted().toList()
    )
}