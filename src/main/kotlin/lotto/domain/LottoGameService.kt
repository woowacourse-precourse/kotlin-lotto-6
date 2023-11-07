package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Model.Lotto
import lotto.Model.LottoMatchResult
import lotto.Model.LottoResult
import lotto.util.Constants.Companion.LOTTO_PRICE
import lotto.util.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.util.Constants.Companion.MIN_LOTTO_NUMBER
import lotto.View.InputView
import lotto.util.Constants.Companion.FIFTH_REWARD_PRICE
import lotto.util.Constants.Companion.FIRST_REWARD_PRICE
import lotto.util.Constants.Companion.FOURTH_REWARD_PRICE
import lotto.util.Constants.Companion.LOTTO_SIZE
import lotto.util.Constants.Companion.PERCENT
import lotto.util.Constants.Companion.SECOND_REWARD_PRICE
import lotto.util.Constants.Companion.THIRD_REWARD_PRICE

class LottoGameService : LottoGame {
    override fun getQuantity(purchaseAmount: Int): Int = purchaseAmount / LOTTO_PRICE


    override fun createRandomLottoNumbers(quantity: Int): List<Lotto> = List(quantity) {
       Lotto(
           Randoms.pickUniqueNumbersInRange(
               MIN_LOTTO_NUMBER,
               MAX_LOTTO_NUMBER,
               LOTTO_SIZE,
           ).sorted() // 오름차순으로 정렬
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
        val reward = lottoMatchResult.sixMatching * FIRST_REWARD_PRICE +
                lottoMatchResult.fiveMatchingWithBonus * SECOND_REWARD_PRICE +
                lottoMatchResult.fiveMatching * THIRD_REWARD_PRICE +
                lottoMatchResult.fourMatching * FOURTH_REWARD_PRICE +
                lottoMatchResult.threeMatching * FIFTH_REWARD_PRICE

        return (reward.toFloat() / purchaseAmount * PERCENT)
    }
}
