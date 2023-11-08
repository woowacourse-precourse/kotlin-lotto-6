package lotto.model.random

import camp.nextstep.edu.missionutils.Randoms

class DefaultRandomGenerator : RandomGenerator {

    override fun pickUniqueNumberInRange(start: Int, end: Int, size: Int): List<Int> =
        Randoms.pickUniqueNumbersInRange(start, end, size)
}