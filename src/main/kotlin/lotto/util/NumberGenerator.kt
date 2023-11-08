package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun generateNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, GENERATE_COUNT)
        return numbers.sorted()
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val GENERATE_COUNT = 6
    }
}