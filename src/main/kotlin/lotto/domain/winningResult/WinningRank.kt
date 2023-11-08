package lotto.domain.winningResult

import lotto.domain.Money

enum class WinningRank(val description: String, val prize: Money) {
    NONE("꽝", Money(0)),
    FIFTH("3개 일치", Money(5_000)),
    FOURTH("4개 일치", Money(50_000)),
    THIRD("5개 일치", Money(1_500_000)),
    SECOND("5개 일치, 보너스 볼 일치", Money(30_000_000)),
    FIRST("6개 일치", Money(2_000_000_000));

    companion object {
        fun getRank(matchingCount: Int, isBonusNumberMatched: Boolean): WinningRank =
            when (matchingCount) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> if (isBonusNumberMatched) SECOND else THIRD
                6 -> FIRST
                else -> NONE
            }
    }
}