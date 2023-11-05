package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoBuilder {
    fun buildLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}