package lotto.message

object ControlMessage {
    const val INPUT_MONEY = "구입 금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."

    const val SHOW_TICKET = "개를 구매했습니다."
    const val SHOW_WINNING = "\n당첨 통계\n---\n"

    const val SHOW_THREE_AGREEMENT = "3개 일치 (5,000원) - "
    const val SHOW_FOUR_AGREEMENT = "4개 일치 (50,000원) - "
    const val SHOW_FIVE_AGREEMENT = "5개 일치 (1,500,000원) - "
    const val SHOW_FIVE_AND_ONE_BONUS_AGREEMENT = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    const val SHOW_SIX_AGREEMENT = "6개 일치 (2,000,000,000원) - "
    const val SHOW_RATE_OF_RETURN = "총 수익률은 "
}