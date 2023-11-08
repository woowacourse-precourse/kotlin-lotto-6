package lotto.model.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import lotto.model.domain.WinningLotto

class Service {
    fun generateWinningLotto(): WinningLotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val bonusNumber: Int = Randoms.pickNumberInList((1..45).toList().minus(numbers))
        return WinningLotto(Lotto(numbers), bonusNumber)
    }

    fun compareLotto(winningLotto: WinningLotto, lotto: Lotto): Rank {
        val hitList: List<Boolean> = lotto.numbers.map { it in winningLotto.lotto.numbers }
        val hitBonus: Boolean = winningLotto.bonusNumber in lotto.numbers
        return when (hitList.count { it == true }) {
            6 -> Rank.FIRST
            5 -> if (hitBonus) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.MISS
        }
    }
}