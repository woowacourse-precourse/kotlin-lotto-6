package lotto

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun createRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            Constants.Numbers.RANDOM_NUMBERS_RANGE_START.value,
            Constants.Numbers.RANDOM_NUMBERS_RANGE_END.value,
            Constants.Numbers.RANDOM_NUMBERS_SIZE.value
        )
}