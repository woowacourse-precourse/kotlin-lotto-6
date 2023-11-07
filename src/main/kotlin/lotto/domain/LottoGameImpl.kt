package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoResult
import lotto.utils.Constant.FIFTH_REWARD
import lotto.utils.Constant.FIRST_REWARD
import lotto.utils.Constant.FOURTH_REWARD
import lotto.utils.Constant.LOTTO_COST
import lotto.utils.Constant.LOTTO_SIZE
import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER
import lotto.utils.Constant.PERCENT
import lotto.utils.Constant.SECOND_REWARD
import lotto.utils.Constant.THIRD_REWARD

class LottoGameImpl : LottoGame {

    override fun getQuantity(purchaseAmount: Int): Int = purchaseAmount / LOTTO_COST

    override fun createRandomLottoNumbers(quantity: Int): List<Lotto> = List(quantity) {
        Lotto(
            Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_SIZE,
            ).sorted()
        )
    }

    override fun getLottoResults(
        lottoNumbers: List<Lotto>,
        winningNumber: Lotto,
        bonusNumber: Int,
    ): List<LottoResult> = lottoNumbers.map { lotto ->
        val matchedCount = lotto.getNumbers().count { it in winningNumber.getNumbers() }
        val hasBonus = bonusNumber in lotto.getNumbers()
        LottoResult(matchedCount = matchedCount, hasBonus = hasBonus)
    }

    override fun getLottoMatchResult(lottoResults: List<LottoResult>): LottoMatchResult =
        lottoResults.fold(LottoMatchResult()) { result, (matchedCount, hasBonus) ->
            when (matchedCount) {
                6 -> result.copy(sixMatching = result.sixMatching + 1)
                5 -> {
                    if (hasBonus) result.copy(fiveMatchingWithBonus = result.fiveMatchingWithBonus + 1)
                    else result.copy(fiveMatching = result.fiveMatching + 1)
                }

                4 -> result.copy(fourMatching = result.fourMatching + 1)
                3 -> result.copy(threeMatching = result.threeMatching + 1)
                else -> result
            }
        }

    override fun calculateRate(lottoMatchResult: LottoMatchResult, purchaseAmount: Int): Float {
        val reward = lottoMatchResult.sixMatching * FIRST_REWARD +
                lottoMatchResult.fiveMatchingWithBonus * SECOND_REWARD +
                lottoMatchResult.fiveMatching * THIRD_REWARD +
                lottoMatchResult.fourMatching * FOURTH_REWARD +
                lottoMatchResult.threeMatching * FIFTH_REWARD

        return (reward.toFloat() / purchaseAmount * PERCENT)
    }
}