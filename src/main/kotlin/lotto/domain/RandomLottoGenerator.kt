package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator : RandomGenerator {
    override fun pickNumberInRange(startNum: Int, endNum: Int, size: Int): List<Int> {
        return Randoms.pickUniqueNumbersInRange(startNum, endNum, 6)
    }
}