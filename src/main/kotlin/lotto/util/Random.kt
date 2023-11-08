package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class Random {
    fun lottoGenerator(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}