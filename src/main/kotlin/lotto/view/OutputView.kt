package lotto.view

import lotto.model.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoReward
import lotto.model.LottoWinningResult
import lotto.utils.Constant.BONUS_NUMBER_MESSAGE
import lotto.utils.Constant.LOTTO_QUANTITY_MESSAGE
import lotto.utils.Constant.LOTTO_WINNING_NUMBER_MESSAGE
import lotto.utils.Constant.MATCH_PRIZE_BONUS_MESSAGE
import lotto.utils.Constant.MATCH_PRIZE_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_MESSAGE
import lotto.utils.Constant.WINNING_STATISTICS_HEADER_MESSAGE
import lotto.utils.Constant.YIELD_MESSAGE

class OutputView {

    fun printAmountMessage() = println(PURCHASE_AMOUNT_MESSAGE)

    fun printLottoQuantity(quantity: Int) = println(LOTTO_QUANTITY_MESSAGE.format(quantity))

    fun printLottoNumbers(lottoNumbers: List<Lotto>) =
        lottoNumbers.forEach { lottoNumber -> println(lottoNumber.getNumbers()) }

    fun printLottoWinningNumber() = println(LOTTO_WINNING_NUMBER_MESSAGE)

    fun printBonusNumber() = println(BONUS_NUMBER_MESSAGE)

    fun printLottoWinningResults(lottoWinningResult: LottoWinningResult) {
        println(WINNING_STATISTICS_HEADER_MESSAGE)

        LottoReward.entries.forEach { reward ->
            printMatchCountMessage(reward, lottoWinningResult)
        }

        println(YIELD_MESSAGE.format(lottoWinningResult.rate))
    }

    private fun printMatchCountMessage(reward: LottoReward, lottoWinningResult: LottoWinningResult) {
        val matchCount = when(reward) {
            LottoReward.FIFTH -> lottoWinningResult.lottoMatchResult.threeMatching
            LottoReward.FOURTH -> lottoWinningResult.lottoMatchResult.fourMatching
            LottoReward.THIRD -> lottoWinningResult.lottoMatchResult.fiveMatching
            LottoReward.SECOND -> lottoWinningResult.lottoMatchResult.fiveMatchingWithBonus
            LottoReward.FIRST -> lottoWinningResult.lottoMatchResult.sixMatching
        }

        val message = if (reward == LottoReward.SECOND) MATCH_PRIZE_BONUS_MESSAGE else MATCH_PRIZE_MESSAGE
        println(message.format(reward.matchedCount, reward.prize, matchCount))
    }

}