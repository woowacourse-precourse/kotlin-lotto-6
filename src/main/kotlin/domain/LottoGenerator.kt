package domain

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun createLottoNumber(): List<Int> =
        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT)

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_COUNT = 6
    }
}