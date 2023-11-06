package lotto.domain.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoService {

    fun createLotto(): Lotto {
        val lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(lotteryNumbers)
    }

}