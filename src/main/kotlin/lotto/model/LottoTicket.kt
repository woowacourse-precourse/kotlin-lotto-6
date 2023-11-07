package lotto.model

import LOTTO_MAX_NUMBER
import LOTTO_MIN_NUMBER
import LOTTO_SIZE
import camp.nextstep.edu.missionutils.Randoms

class LottoTicket {
    var ticket: List<Int>

    init {
        ticket = generateRandomNumbers()
        ticket = ticket.sorted()
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE)
    }
}