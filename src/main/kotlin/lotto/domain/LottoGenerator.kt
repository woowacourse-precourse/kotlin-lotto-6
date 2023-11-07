package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.model.Lotto
import lotto.domain.model.Lottos
import lotto.domain.model.Purchase
import lotto.util.Constants

class LottoGenerator {

    fun make(purchase: Purchase): Lottos {
        val lottoCount = purchase.getLottoCount()
        return Lottos(List(lottoCount) { generateLotto() })
    }

    private fun generateLotto() = Lotto(getSortedNumber())

    private fun getSortedNumber() = generateNumber().sorted()

    private fun generateNumber(): List<Int> =
        Randoms.pickUniqueNumbersInRange(Constants.LOTTO_START_NUM, Constants.LOTTO_END_NUM, Constants.LOTTO_NUM_CNT)
}
