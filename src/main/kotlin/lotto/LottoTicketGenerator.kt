package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoTicketGenerator {
    fun createAutoTicket() = Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT).sorted().toList())

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}