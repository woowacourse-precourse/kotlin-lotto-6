package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun lottoPublish(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}