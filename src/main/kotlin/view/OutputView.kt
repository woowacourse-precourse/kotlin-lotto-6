package view

import lotto.Lotto
import lottoranking.LottoRanking

object OutputView {
    private const val PLEASE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val LOTTO_PRICE = 1000
    private const val BOUGHT_NUMBER_OF_THEM = "개를 구매했습니다."
    private const val LEFT_SQUARE_BRACKET = "["
    private const val RIGHT_SQUARE_BRACKET = "]"
    private const val PLEASE_ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val PLEASE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주새요."
    private const val WINNING_STATISTICS = "당첨 통계"
    private const val THREE_DOT = "---"
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
    private const val ERROR = "[ERROR]"
    private const val LINE_BREAK = "\n"

    fun pleaseEnterPurchaseAmount() {
        println(PLEASE_ENTER_PURCHASE_AMOUNT)
    }

    fun purchasedIssuedLottoTickets(lottoPurchaseAmount: Int) {
        println("$LINE_BREAK${lottoPurchaseAmount / LOTTO_PRICE}$BOUGHT_NUMBER_OF_THEM")
    }

    fun purchasedIssuedLottery(lottoNumbers: Lotto) {
        print(LEFT_SQUARE_BRACKET)
        print(lottoNumbers.getNumbers().joinToString(", "))
        print("$RIGHT_SQUARE_BRACKET$LINE_BREAK")
    }

    fun pleaseEnterWinningNumber() {
        println("$LINE_BREAK$PLEASE_ENTER_WINNING_NUMBER")
    }

    fun pleaseEnterBonusNumber() {
        println("$LINE_BREAK$PLEASE_ENTER_BONUS_NUMBER")
    }

    fun winningStatistics() {
        println("$LINE_BREAK$WINNING_STATISTICS")
    }

    fun threeDotLine() {
        println(THREE_DOT)
    }

    fun winningMatchResult(lottoRank: LottoRanking) {
        when (lottoRank) {
            LottoRanking.FIRST -> println("${lottoRank.correct}$PART $SAME $FIRST_REWARD $DOT ${lottoRank.count}$PART")
            LottoRanking.SECOND -> println("${lottoRank.correct}$PART $SAME$REST $BONUS_BALL $SAME $SECOND_REWARD $DOT ${lottoRank.count}$PART")
            LottoRanking.THIRD -> println("${lottoRank.correct}$PART $SAME $THIRD_REWARD $DOT ${lottoRank.count}$PART")
            LottoRanking.FOURTH -> println("${lottoRank.correct}$PART $SAME $FOURTH_REWARD $DOT ${lottoRank.count}$PART")
            LottoRanking.FIFTH -> println("${lottoRank.correct}$PART $SAME $FIFTH_REWARD $DOT ${lottoRank.count}$PART")
        }
    }

    fun totalReturn(totalReturn: Double) {
        println("$TOTAL_RETURN $totalReturn$IT_IS_PERCENT")
    }

    fun error(message: String) {
        println("$ERROR $message")
    }
}
