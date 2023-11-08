package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Constants.LOTTO_COUNT
import lotto.Constants.MAX_LOTTO_NUMBER
import lotto.Constants.MIN_LOTTO_NUMBER

object LottoBuilder {
    fun buildLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT)
        return Lotto(numbers)
    }
}
