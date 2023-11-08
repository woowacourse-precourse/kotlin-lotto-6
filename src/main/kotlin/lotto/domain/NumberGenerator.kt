package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun createRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            RANDOM_NUMBERS_RANGE_START,
            RANDOM_NUMBERS_RANGE_END,
            RANDOM_NUMBERS_SIZE
        ).sorted()

    companion object {
        private const val RANDOM_NUMBERS_RANGE_START: Int = 1
        private const val RANDOM_NUMBERS_RANGE_END: Int = 45
        private const val RANDOM_NUMBERS_SIZE: Int = 6
    }
}