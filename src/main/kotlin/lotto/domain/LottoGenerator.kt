package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants

class LottoGenerator(private val lottoCount: Int) {

    private fun generateRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.CNT_LOTTO_NUMBER
        ).sorted()
    }

    fun generateLottoTickets(): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lottoNumbers = generateRandomLotto()
            val lotto = Lotto(lottoNumbers)
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

}