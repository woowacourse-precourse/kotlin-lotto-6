package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT

class RandomNumberGenerator : NumberGenerator{
    override fun generateNumbers() : List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_NUMBER_COUNT)
        return numbers.toList()
    }

    companion object{
        private val MIN_VALUE = 1
        private val MAX_VALUE = 45
    }
}