package lotto.domain

import lotto.constant.PrintText

class Lottoes(private val lottoes: List<Lotto>) {

    fun calculateGameResult(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoGameResult {
        val result = LottoGameResult()
        lottoes.forEach {
            val sameNumberCounts = it.compareWinningNumbers(winningNumbers)
            val sameBonus = it.compareBonusNumber(bonusNumber)
            result.calculateResult(sameNumberCounts, sameBonus)
        }
        return result
    }


    fun toLottesResult(): String = lottoes.joinToString(separator = PrintText.SEPARATE_LOTTES.text) {
        it.toLottoNumbersResult()
    }
}