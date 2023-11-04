package lotto.view

import lotto.model.Lotto
import lotto.model.LottoMatchResult
import lotto.model.LottoReward
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

    fun printLottoWinningResults(lottoMatchResult: LottoMatchResult, rate: Float) {
        println(WINNING_STATISTICS_HEADER_MESSAGE)
        println(MATCH_PRIZE_MESSAGE.format(LottoReward.FIFTH.matchedCount, LottoReward.FIFTH.prize, lottoMatchResult.threeMatching))
        println(MATCH_PRIZE_MESSAGE.format(LottoReward.FOURTH.matchedCount, LottoReward.FOURTH.prize, lottoMatchResult.fourMatching))
        println(MATCH_PRIZE_MESSAGE.format(LottoReward.THIRD.matchedCount, LottoReward.THIRD.prize, lottoMatchResult.fiveMatching))
        println(MATCH_PRIZE_BONUS_MESSAGE.format(LottoReward.SECOND.matchedCount, LottoReward.SECOND.prize, lottoMatchResult.fiveMatchingWithBonus))
        println(MATCH_PRIZE_MESSAGE.format(LottoReward.FIRST.matchedCount, LottoReward.FIRST.prize, lottoMatchResult.sixMatching))
        println(YIELD_MESSAGE.format(rate))
    }
}