package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoShop {
    fun issueLotto(): Lotto {
        return Lotto(generateNumbers())
    }

    private fun generateNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6)
    }
}