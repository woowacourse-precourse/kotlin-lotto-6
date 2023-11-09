package lotto.domain.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.domain.enum.number.UnitNumber

class LottoService {

    fun createLotto(): Lotto {
        val lotteryNumbers = Randoms.pickUniqueNumbersInRange(
            UnitNumber.MIN_LOTTO_NUMBER.number,
            UnitNumber.MAX_LOTTO_NUMBER.number,
            UnitNumber.LOTTO_COUNT.number
        )
        return Lotto(lotteryNumbers)
    }

}