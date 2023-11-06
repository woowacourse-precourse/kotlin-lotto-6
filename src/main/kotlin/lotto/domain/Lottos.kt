package lotto.domain

import lotto.constant.PrintText

class Lottos(private val lottos: List<Lotto>) {

    fun calculateGameResult(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoGameResult {
        val result = LottoGameResult()
        lottos.forEach {
            val sameNumberCounts = it.compareWinningNumbers(winningNumbers)
            val sameBonus = it.compareBonusNumber(bonusNumber)
            result.calculateResult(sameNumberCounts, sameBonus)
        }
        return result
    }


    fun toLottosResult(): String = lottos.joinToString(separator = PrintText.SEPARATE_LOTTES.text) {
        it.toLottoNumbersResult()
    }
}