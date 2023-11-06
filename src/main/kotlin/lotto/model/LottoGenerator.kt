package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {

    fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }
}