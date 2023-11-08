package lotto.model.domain

import java.text.DecimalFormat

enum class Rank(private val countOfMatch: Int, private val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    override fun toString(): String {
        if (this == Rank.THIRD) return "${countOfMatch}개 일치, 보너스 볼 일치 (${DecimalFormat("#,###").format(winningMoney)}원)"
        return "${countOfMatch}개 일치 (${DecimalFormat("#,###").format(winningMoney)}원)"
    }

    fun getMoney(): Int {
        return winningMoney
    }
}