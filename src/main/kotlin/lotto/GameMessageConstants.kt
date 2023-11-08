package lotto

import java.text.DecimalFormat

object GameMessageConstants {
    const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val DIVIDER_MESSAGE = "---"

    const val THREE_MATCHES = "3개 일치 (5,000원)"
    const val FOUR_MATCHES = "4개 일치 (50,000원)"
    const val FIVE_MATCHES = "5개 일치 (1,500,000원)"
    const val FIVE_MATCHES_WITH_BONUS_BALL = "5개 일치, 보너스 볼 일치 (30,000,000원)"
    const val SIX_MATCHES = "6개 일치 (2,000,000,000원)"

    fun purchasedLottoMessage(count: Int) = "${count}개를 구매했습니다."
    fun totalReturnRateMessage(returnRate: Double) = "총 수익률은 ${DecimalFormat("#.##").format(returnRate)}%입니다."
    fun countResultMessage(rank: Rank, results: LottoResult) = "${rank.description} - ${results.statistic[rank]}개"
    fun tickets(lotto: Lotto) = "$lotto"
}
