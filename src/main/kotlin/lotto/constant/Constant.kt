package lotto.constant

object Constant {
    const val MIN_LOTTO_NUM = 1
    const val MAX_LOTTO_NUM = 45
    const val LOTTO_LENGTH = 6
    const val BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요."
    const val INPUT_WIN_NUMBER_REGEX = "\\d[1-45],\\d[1-45],\\d[1-45],\\d[1-45],\\d[1-45],\\d[1-45]"
    const val BONUS_NUMBER_REGEX = "\\d[1-45]"
    const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    const val PURCHASE_DIVISOR = 1000
    const val BUY_NUMBER_MESSAGE = "개를 구매했습니다."
    const val EQUAL_MESSAGE = "개 일치"
    const val NUMBER_MESSAGE = "개"
    const val THREE_PRIZE = " (5,000원)"
    const val FOUR_PRIZE = " (50,000원)"
    const val FIVE_PRIZE = " (1,500,000원)"
    const val BONUS_PRIZE = ", 보너스 볼 일치 (30,000,000원)"
    const val SIX_PRIZE = "(2,000,000,000원)"
}