package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constant.LOTTO_NUMBER_SIZE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

object NumberIssuer {
    fun issueNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE)
        return numbers
    }
}