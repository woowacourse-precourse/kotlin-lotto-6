package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator {
    fun makeRandomNumbers():List<Int> {
         return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}

