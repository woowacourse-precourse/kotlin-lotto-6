package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumbersGenerator {

    fun generate(): List<Int> = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT)

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val NUMBER_COUNT = 6
    }
}