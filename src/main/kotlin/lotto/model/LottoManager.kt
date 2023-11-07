package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.LOTTO_COUNT
import lotto.exception.IllegalStateException

class LottoManager {

    fun getMoneyToCount(money: Long): Long {
        while (money < LOTTO_PRICE) {
            println(IllegalStateException.stateNotInitialized)
        }

        return money / LOTTO_PRICE
    }

    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT).sorted())
    }
}