package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

class RandomUtils {

    fun pickLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUM_MIN, LOTTO_NUM_MAX, LOTTO_SIZE)
    }

    companion object {
        const val LOTTO_NUM_MIN = 1
        const val LOTTO_NUM_MAX = 45
        const val LOTTO_SIZE = 6
    }
}