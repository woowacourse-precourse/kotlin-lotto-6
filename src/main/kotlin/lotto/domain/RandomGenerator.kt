package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomGenerator {

    fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            Lotto.MIN_NUMBER,
            Lotto.MAX_NUMBER,
            Lotto.LOTTO_LENGTH
        )
        return Lotto(numbers)
    }

}