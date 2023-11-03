package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    fun getSortedNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}