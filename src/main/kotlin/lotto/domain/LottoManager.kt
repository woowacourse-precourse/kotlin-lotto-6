package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoManager {

    fun makeLotto(): Lotto = Lotto(makeRandomNumbers())

    private fun makeRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, LOTTO_COUNT
        )

    companion object {
        const val LOTTO_START_INCLUSIVE = 1
        const val LOTTO_END_INCLUSIVE = 45
        const val LOTTO_COUNT = 6
    }
}