package lotto

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbersGenerator {
    fun makeRandomNumbers():List<Int> {

        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }
}

