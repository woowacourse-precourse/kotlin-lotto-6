package lotto.model

import lotto.dto.LottoMatchCount
import lotto.dto.WinningAndBonusNumbers
import lotto.model.validation.LottoNumber

object LottoCalculator {
    fun matchCount(
        lotto: List<LottoNumber>,
        winningAndBonusNumbers: WinningAndBonusNumbers
    ): LottoMatchCount {
        val (winningnumbers, bonusNumber) = winningAndBonusNumbers

        val winning = lotto.count { winningnumbers.contains(it) }
        val bonus = lotto.count { it == bonusNumber }

        return LottoMatchCount(winning, bonus)
    }
}