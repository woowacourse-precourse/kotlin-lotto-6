package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Const

class RandomNumbersGenerator {
    fun makeRandomNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(Const.LOTTO_MIN_NUMBER, Const.LOTTO_MAX_NUMBER, Const.LOTTO_SIZE)
        return numbers.sorted()
    }
}

