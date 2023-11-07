package lotto.store.machine

import java.math.BigDecimal

enum class LottoResult(
        val winnings: BigDecimal,
        val matchCount: Int
) {
    FIFTH(BigDecimal(5_000),  3),
    FOURTH(BigDecimal(50_000),  4),
    THIRD(BigDecimal(1_500_000),  5),
    SECOND(BigDecimal(30_000_000),  5),
    FIRST(BigDecimal(2_000_000_000), 6)
}