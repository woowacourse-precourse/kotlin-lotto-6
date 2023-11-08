package lottonumbercomparator

import lotto.Lotto
import lottoranking.LottoRanking
import winningnumber.WinningNumber

class LottoNumberComparatorImpl : LottoNumberComparator {
    override fun compare(winningNumber: WinningNumber, lotto: Lotto) {

        val correctCount = winningNumber.numbers.count { lotto.getNumbers().contains(it) }
        val isBonusNumberCorrect = lotto.getNumbers().contains(winningNumber.bonusNumber)

        when {
            correctCount == FIRST_CORRECT_COUNT -> LottoRanking.FIRST.count++
            correctCount == SECOND_CORRECT_COUNT && isBonusNumberCorrect -> LottoRanking.SECOND.count++
            correctCount == SECOND_CORRECT_COUNT -> LottoRanking.THIRD.count++
            correctCount == THIRD_CORRECT_COUNT -> LottoRanking.FOURTH.count++
            correctCount == FOURTH_CORRECT_COUNT -> LottoRanking.FIFTH.count++
        }
    }

    companion object {
        private const val FIRST_CORRECT_COUNT = 6
        private const val SECOND_CORRECT_COUNT = 5
        private const val THIRD_CORRECT_COUNT = 4
        private const val FOURTH_CORRECT_COUNT = 3
    }
}