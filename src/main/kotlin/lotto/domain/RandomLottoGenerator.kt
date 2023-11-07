package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto.Companion.MAX_LOTTO_SIZE

class RandomLottoGenerator : RandomGenerator {
    override fun pickNumberInRange(startNum: Int, endNum: Int, size: Int): List<Int> {
        return Randoms.pickUniqueNumbersInRange(startNum, endNum, MAX_LOTTO_SIZE)
    }
}