package lotto.View

import lotto.Model.Lotto
import lotto.Model.LottoWinningResult
import lotto.util.Constants.Companion.OUTPUT_LOTTO_COUNT
import lotto.Model.WinningPrize
import lotto.util.Constants.Companion.INPUT_BONUS_NUMBER_MESSAGE
import lotto.util.Constants.Companion.INPUT_PURCHASE_PRICE_MESSAGE
import lotto.util.Constants.Companion.INPUT_WINNING_NUMBERS_MESSAGE
import lotto.util.Constants.Companion.MATCH_PRIZE_BONUS_MESSAGE
import lotto.util.Constants.Companion.MATCH_PRIZE_MESSAGE
import lotto.util.Constants.Companion.OUTPUT_PURCHASE_COUNT_MESSAGE
import lotto.util.Constants.Companion.OUTPUT_RETURN_RATE_PERCENTAGE_MESSAGE

class OutputView { // 출력되는 것들을 관리하는 클래스.

    fun printPurchaseLottoPrice() = println(INPUT_PURCHASE_PRICE_MESSAGE)

    fun printWinningNumbers() = println(INPUT_WINNING_NUMBERS_MESSAGE)

    fun printBonusNumber() = println(INPUT_BONUS_NUMBER_MESSAGE)

    fun printLottoQuantity(quantity: Int) = println(OUTPUT_PURCHASE_COUNT_MESSAGE.format(quantity))

    fun printLottoNumbers(lottoNumbers: List<Lotto>) =
        lottoNumbers.forEach { lottoNumber -> println(lottoNumber.getNumbers()) }

    fun printWinningDetails(winningDetails: LottoWinningResult) { // 당첨 통계 & 내역 출력.
        println(OUTPUT_LOTTO_COUNT)
        println("---")
        WinningPrize.entries.forEach { reward ->
            printMatchCountMessage(reward, winningDetails)
        }

        println(OUTPUT_RETURN_RATE_PERCENTAGE_MESSAGE.format(winningDetails.rate))
    }

    private fun printMatchCountMessage(reward: WinningPrize, lottoWinningDetail: LottoWinningResult) {
        val matchCount = when (reward) {
            WinningPrize.GRADE_5 -> lottoWinningDetail.lottoMatchResult.threeMatching
            WinningPrize.GRADE_4 -> lottoWinningDetail.lottoMatchResult.fourMatching
            WinningPrize.GRADE_3 -> lottoWinningDetail.lottoMatchResult.fiveMatching
            WinningPrize.GRADE_2 -> lottoWinningDetail.lottoMatchResult.fiveMatchingWithBonus
            WinningPrize.GRADE_1 -> lottoWinningDetail.lottoMatchResult.sixMatching
        }

        val message = if (reward == WinningPrize.GRADE_2) MATCH_PRIZE_BONUS_MESSAGE else MATCH_PRIZE_MESSAGE
        println(message.format(reward.matchedCount, reward.prize, matchCount))
    }
}