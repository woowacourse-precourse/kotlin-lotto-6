package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.model.Lotto
import lotto.domain.model.Purchase
import lotto.util.Constants

class LottoGenerator(val purchase: Purchase) {

    fun getLotto(purchase: Purchase): MutableList<Lotto> {
        val lottoCount = purchase.getLottoCount()
        val lottos = mutableListOf<Lotto>()
        for (i in 1..lottoCount) {
            lottos.add(generateLotto())
        }
        return lottos
    }

    private fun generateLotto() = Lotto(getSortedNumber())

    private fun getSortedNumber() = generateNumber().sorted()

    private fun generateNumber(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Constants.LOTTO_START_NUM, Constants.LOTTO_END_NUM, Constants.LOTTO_NUM_CNT)
}
