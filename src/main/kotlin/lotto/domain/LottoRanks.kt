package lotto.domain

import lotto.Lotto

enum class Prize(val matchingNumbers: Int, val prizeAmount: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_WITH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000)
}

class LottoRanks {

}