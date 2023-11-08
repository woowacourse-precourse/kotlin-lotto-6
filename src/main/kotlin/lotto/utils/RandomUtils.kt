package lotto.utils

import camp.nextstep.edu.missionutils.Randoms

class RandomUtils {

    fun pickLottoNum(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}