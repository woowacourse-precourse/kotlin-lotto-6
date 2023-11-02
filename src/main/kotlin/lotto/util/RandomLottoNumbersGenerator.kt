package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoNumbersGenerator {

    fun generate() = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}