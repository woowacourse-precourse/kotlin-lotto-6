package lotto.model

import lotto.model.seller.Money

enum class Rank(val prize: Money) {
    First(Money(2_000_000_000)),
    Second(Money(30_000_000)),
    Third(Money(1_500_000)),
    Fourth(Money(50_000)),
    Fifth(Money(5_000));

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