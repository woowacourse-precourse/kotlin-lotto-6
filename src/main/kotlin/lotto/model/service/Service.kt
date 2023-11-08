package lotto.model.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.domain.Lotto
import lotto.model.domain.WinningLotto

class Service {
    fun generateWinningLotto(): WinningLotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val bonusNumber: Int = Randoms.pickNumberInList((1..45).toList().minus(numbers))
        return WinningLotto(Lotto(numbers), bonusNumber)
    }
}