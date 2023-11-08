package lotto.model

import lotto.dto.LottoMatchCount
import lotto.dto.WinningAndBonusNumbers
import lotto.model.validation.LottoNumber

object LottoCalculator {
    fun calculate(
        lotto: List<LottoNumber>,
        winningAndBonusNumbers: WinningAndBonusNumbers
    ): LottoMatchCount {
        val (winningnumbers, bonusNumber) = winningAndBonusNumbers

        var winningMatchCount = 0
        for (num in lotto) {
            if (winningnumbers.contains(num)) {
                winningMatchCount += 1
            }
        }

        return LottoMatchCount(winningMatchCount, lotto.count { it == bonusNumber })
    }
}