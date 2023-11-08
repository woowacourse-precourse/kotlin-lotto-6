package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoManager {

    fun purchaseLotto(): Lotto = Lotto(makeRandomNumbers())

    private fun makeRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            LottoRule.START_INCLUSIVE.num,
            LottoRule.END_INCLUSIVE.num,
            LottoRule.COUNT.num
        )
}