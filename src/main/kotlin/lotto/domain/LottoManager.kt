package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto

class LottoManager {

    fun purchaseLotto(): Lotto = Lotto(makeRandomNumbers())

    fun calculateResult(
        purchasePrice: Int,
        totalProceeds: Int
    ): Double = String.format(
        "%.1f",((totalProceeds.toDouble() / purchasePrice.toDouble())*100)
    ).toDouble()

    fun getMathResult(matchCount: Int): GameResult? =
        GameResult.entries.find { it.matchNumber == matchCount }

    fun isBonusResult(gameResult: GameResult): Boolean =
        gameResult == GameResult.THIRD

    fun getMathBonusResult(bonusResult: Boolean): GameResult =
        if (bonusResult) GameResult.SECOND else GameResult.THIRD

    private fun makeRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            LottoRule.START_INCLUSIVE.num,
            LottoRule.END_INCLUSIVE.num,
            LottoRule.COUNT.num
        )
}