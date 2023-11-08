package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.WinningLotto

class LottoManager {

    fun purchaseLotto(): Lotto = Lotto(makeRandomNumbers())

    fun calculateResult(
        purchasePrice: Int,
        totalProceeds: Int
    ): Double = String.format(
        RETURN_FORMAT, ((totalProceeds.toDouble() / purchasePrice.toDouble()) * RETURN_RATE)
    ).toDouble()

    fun getMathResult(matchCount: Int): GameResult? =
        GameResult.entries.find { it.matchNumber == matchCount }

    fun checkBonusResult(
        gameResult: GameResult?,
        winningLotto: WinningLotto,
        lotto: Lotto
    ): GameResult? {
        return if (isBonusResult(gameResult)) {
            val bonusResult = winningLotto.checkWinningBonusNumber(lotto.changeLottoNumbersToSet())
            getMathBonusResult(bonusResult)
        } else {
            gameResult
        }
    }

    private fun isBonusResult(gameResult: GameResult?): Boolean =
        gameResult == GameResult.THIRD

    private fun getMathBonusResult(bonusResult: Boolean): GameResult =
        if (bonusResult) GameResult.SECOND else GameResult.THIRD

    private fun makeRandomNumbers(): List<Int> =
        Randoms.pickUniqueNumbersInRange(
            LottoRule.START_INCLUSIVE.num,
            LottoRule.END_INCLUSIVE.num,
            LottoRule.COUNT.num
        )

    companion object {
        private const val RETURN_FORMAT = "%.1f"
        private const val RETURN_RATE = 100
    }
}