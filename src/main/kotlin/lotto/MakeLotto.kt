package lotto

import camp.nextstep.edu.missionutils.Randoms

class MakeLotto {

    fun calculateCountingLotto(price: Int): Int {
        return price / 1000
    }

    fun createNonOverlapSixNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }

}