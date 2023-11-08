package lotto.model

enum class LottoMatchNum(val matchingNum: Int) {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    FIVE_PLUS_BONUS(51),
    SIX_MATCH(6),
    EXTRA(-1);

    companion object {
        fun fromValue(value: Int): LottoMatchNum {
            return values().firstOrNull { it.matchingNum == value }?:EXTRA
        }
    }
}

class LottoPrize {
    val winningsPrizeMap: Map<LottoMatchNum, Int> = mapOf(
        LottoMatchNum.THREE_MATCH to 5000,
        LottoMatchNum.FOUR_MATCH to 50000,
        LottoMatchNum.FIVE_MATCH to 1500000,
        LottoMatchNum.FIVE_PLUS_BONUS to 30000000,
        LottoMatchNum.SIX_MATCH to 2000000000
    )
}