package lotto.model

import lotto.model.seller.Money

enum class Rank(val prize: Money, val matchingCount: Int) {
    First(Money(2_000_000_000), 6),
    Second(Money(30_000_000), 5),
    Third(Money(1_500_000), 5),
    Fourth(Money(50_000), 4),
    Fifth(Money(5_000), 3);

    companion object {
        fun of(matchingCount: Int, isMatchedBonus: Boolean): Rank? =
            when (matchingCount) {
                6 -> First
                5 -> if (isMatchedBonus) Second else Third
                4 -> Fourth
                3 -> Fifth
                else -> null
            }
    }
}