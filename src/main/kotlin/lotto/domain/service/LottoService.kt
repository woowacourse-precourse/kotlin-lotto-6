package lotto.domain.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoService(private val lotto: Lotto) {

    fun createLotto(): Lotto {
        val lotteryNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(lotteryNumbers)
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber: Int) =
        LottoCalculator(winningNumbers, bonusNumber).checkWinningRank(lotto = lotto)

}