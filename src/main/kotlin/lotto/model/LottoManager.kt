package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.END_NUMBER
import lotto.util.Constants.LOTTO_NUMBER_SIZE
import lotto.util.Constants.START_NUMBER

class LottoManager {

    fun issueLottoTicket(size: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()

        for (idx in 0 until size) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_SIZE))
            lottoTickets.add(lotto)
        }

        return lottoTickets
    }
}