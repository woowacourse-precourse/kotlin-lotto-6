package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoManager {

    fun issueLottoTicket(size : Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()

        for (idx in 0 until size){
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottoTickets.add(lotto)
        }

        return lottoTickets
    }
}