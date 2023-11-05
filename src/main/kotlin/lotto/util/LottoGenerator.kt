package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_SIZE

class LottoGenerator {
    fun getSortedNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE).sorted()
}