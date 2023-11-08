package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator(private val lottoGenerateCount: Int) {

    private fun generateRandomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            Constants.MIN_LOTTO_NUMBER,
            Constants.MAX_LOTTO_NUMBER,
            Constants.CNT_LOTTO_NUMBER
        ).sorted()
    }

    fun generateLottoTickets(): List<Lotto> {
        val lottoTickets = mutableListOf<Lotto>()
        repeat(lottoGenerateCount) {
            val lottoNumbers = generateRandomLotto()
            val lotto = Lotto(lottoNumbers)
            lottoTickets.add(lotto)
        }
        return lottoTickets
    }

}