package lotto.enums

import lotto.LottoUtil.commaString

sealed class LottoResult(
    val condition: String,
    val winningPrice: Int,
) {

    fun toString(winningCount: Int): String {
        return stringFormat.format(condition, winningPrice.commaString, winningCount)
    }

    private val stringFormat = "%s (%s원) - %d개"

    data object NOTHING : LottoResult("", 0)
    data object FIFTH : LottoResult("3개 일치", 5_000)
    data object FOURTH : LottoResult("4개 일치", 50_000)
    data object THIRD : LottoResult("5개 일치", 1_500_000)
    data object SECOND : LottoResult("5개 일치, 보너스 볼 일치", 30_000_000)
    data object FIRST : LottoResult("6개 일치", 2_000_000_000)
}
