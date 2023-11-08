package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoPublisher {

    fun publishLottoTickets(lottoAmount: Int): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        println("\n${lottoAmount}개를 구매했습니다.")
        repeat(lottoAmount) {
            val lotto = publishLotto()
            lotto.printNumbers()
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

    private fun publishLotto(): Lotto {
        var lotto: Lotto
        try {
            lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        } catch (e: IllegalArgumentException) {
            return publishLotto()
        }
        return lotto
    }
}