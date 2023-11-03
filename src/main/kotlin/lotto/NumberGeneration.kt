package lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberGeneration {
    fun generateNumbers(): MutableList<Int>? {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }
}