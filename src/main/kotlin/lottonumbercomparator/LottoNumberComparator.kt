package lottonumbercomparator

import lotto.Lotto
import winningnumber.WinningNumber

fun interface LottoNumberComparator {

    fun compare(winningNumber: WinningNumber, lotto: Lotto)
}
