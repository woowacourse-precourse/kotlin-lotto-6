package lotto.domain

import kotlin.math.roundToInt

class Player(private var money: Money) {

    fun purchaseLotto(): List<Lotto> {
        val boughtLotto = LottoStore.issueNumbers(money.value)
        return boughtLotto
    }

    fun calculateRevenue(rank: Map<WinningRank, Int>): Double {
        var revenue = 0.0
        rank.forEach { playerRank ->
            revenue += playerRank.key.winningPrize * playerRank.value
        }
        return ((revenue / money.value * 100) * 10).roundToInt() / 10.0
    }

}