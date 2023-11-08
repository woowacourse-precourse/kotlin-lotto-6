package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.*

class LottoGenerator {
    fun generatorLotto(): Lotto {
        val lotto = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE)
        return Lotto(lotto.sorted())
    }
}