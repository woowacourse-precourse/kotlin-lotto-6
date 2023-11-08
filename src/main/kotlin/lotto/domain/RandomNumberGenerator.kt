package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto.Companion.LOTTO_MAX_VALUE
import lotto.domain.Lotto.Companion.LOTTO_MIN_VALUE
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT

class RandomNumberGenerator : NumberGenerator{
    override fun generateNumbers() : List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_NUMBER_COUNT)
        return numbers.toList()
    }
}