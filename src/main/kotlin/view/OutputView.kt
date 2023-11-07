package view

import lottoranking.LottoRanking

object OutputView {
    private const val PLEASE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val BOUGHT_NUMBER_OF_THEM = "개를 구매했습니다."
    private const val PLEASE_ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val PLEASE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주새요."
    private const val WINNING_STATISTICS = "당첨 통계"
    private const val THREE_DOT = "---"
    private const val WINNING_DETAIL = "당첨 내역"
    private const val PART = "개"
    private const val SAME = "일치"
    private const val DOT = "-"
    private const val FIRST_REWARD = "(2,000,000,000원)"
    private const val SECOND_REWARD = "(30,000,000원)"
    private const val THIRD_REWARD = "(1,500,000원)"
    private const val FOURTH_REWARD = "(50,000원)"
    private const val FIFTH_REWARD = "(5,000원)"
    private const val BONUS_BALL = "보너스 볼"
    private const val REST = ","
    private const val TOTAL_RETURN = "총 수익률은"
    private const val IT_IS_PERCENT = "%입니다."

    fun pleaseEnterPurchaseAmount() {
        println(PLEASE_ENTER_PURCHASE_AMOUNT)
    }

    fun purchasedIssuedLottoTickets(lottoPurchaseAmount: Int) {
        println("$lottoPurchaseAmount$BOUGHT_NUMBER_OF_THEM")
    }

    fun pleaseEnterWinningNumber() {
        println(PLEASE_ENTER_WINNING_NUMBER)
    }

    fun pleaseEnterBonusNumber() {
        println(PLEASE_ENTER_BONUS_NUMBER)
    }

    fun winningStatistics() {
        println(WINNING_STATISTICS)
    }

    fun threeDotLine() {
        println(THREE_DOT)
    }

    fun winningDetail() {
        println(WINNING_DETAIL)
    }

    fun winningMatchResult(lottoRank: LottoRanking) {
        when (lottoRank) {
            LottoRanking.FIRST -> println("${lottoRank.correct}$PART $SAME $FIRST_REWARD $DOT ${lottoRank.correct}$PART")
            LottoRanking.SECOND -> println("${lottoRank.correct}$PART $SAME$REST $BONUS_BALL $SAME $SECOND_REWARD $DOT ${lottoRank.correct}$PART")
            LottoRanking.THIRD -> println("${lottoRank.correct}$PART $SAME $THIRD_REWARD $DOT ${lottoRank.correct}$PART")
            LottoRanking.FOURTH -> println("${lottoRank.correct}$PART $SAME $FOURTH_REWARD $DOT ${lottoRank.correct}$PART")
            LottoRanking.FIFTH -> println("${lottoRank.correct}$PART $SAME $FIFTH_REWARD $DOT ${lottoRank.correct}$PART")
        }
    }

    fun totalReturn(totalReturn: Double) {
        println("$TOTAL_RETURN $totalReturn$IT_IS_PERCENT")
    }
}
