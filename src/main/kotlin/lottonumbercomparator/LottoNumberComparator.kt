package lottonumbercomparator

import lotto.Lotto
import lottoranking.LottoRanking
import winningnumber.WinningNumber

fun interface LottoNumberComparator {

    fun compare(winningNumber: WinningNumber, lotto: Lotto): LottoRanking
}
