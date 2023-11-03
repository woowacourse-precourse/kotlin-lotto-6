package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun generateNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }
}