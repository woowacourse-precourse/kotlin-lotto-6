package lotto.utils

object Constants {
    /* Lotto */
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_SIZE = 6

    /* Rank */
    const val FIRST_PLACE = "1등"
    const val SECOND_PLACE = "2등"
    const val THIRD_PLACE = "3등"
    const val FOURTH_PLACE = "4등"
    const val FIFTH_PLACE = "5등"
    const val LOSE_PLACE = "꽝"
    const val MATCHED_SIX = 6
    const val MATCHED_FIVE = 5
    const val MATCHED_FOUR = 4
    const val MATCHED_THREE = 3
    const val FIRST_RANK = 1
    const val LAST_RANK = 5

    /* Profit */
    const val FIFTH_PRIZE_MONEY = 5000
    const val FOURTH_PRIZE_MONEY = 50000
    const val THIRD_PRIZE_MONEY = 1500000
    const val SECOND_PRIZE_MONEY = 30000000
    const val FIRST_PRIZE_MONEY = 2000000000
    const val INITIALIZE_DOUBLE = 0.0
    const val HUNDRED_PERCENTAGE = 100

    /* Validate */
    const val LOTTO_PURCHASE_UNIT = 1000
    const val INITIALIZE_NUMBER = 0
    const val MAX_PURCHASE_PIECE = 100

    /* Statistic */
    private const val MATCH_AMOUNT = "%d개"
    const val FIRST_PLACE_ANNOUNCE = "6개 일치 (2,000,000,000원) - $MATCH_AMOUNT"
    const val SECOND_PLACE_ANNOUNCE = "5개 일치, 보너스 볼 일치 (30,000,000원) - $MATCH_AMOUNT"
    const val THIRD_PLACE_ANNOUNCE = "5개 일치 (1,500,000원) - $MATCH_AMOUNT"
    const val FOURTH_PLACE_ANNOUNCE = "4개 일치 (50,000원) - $MATCH_AMOUNT"
    const val FIFTH_PLACE_ANNOUNCE = "3개 일치 (5,000원) - $MATCH_AMOUNT"

    /* Input Message */
    const val REQUEST_PAY_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    const val REQUEST_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요."
    const val REQUEST_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."

    /* Output Message */
    const val PRINT_ENTER = "\n"
    const val PRINT_PRODUCE_LOTTO_RESULT_MESSAGE = "개를 구매했습니다."
    const val WINNING_STATS_MESSAGE = "당첨 통계"
    const val PRINT_LINE_HYPHEN = "---"
    const val PRINT_PROFIT_MESSAGE_FRONT = "총 수익률은 %.1f"
    const val PRINT_PROFIT_MESSAGE_BACK = "%입니다."

    /* Error Message */
    private const val ERROR_TEXT = "[ERROR] "
    const val ERROR_INPUT_SIZE = ERROR_TEXT + "로또 번호가 6개여야 합니다."
    const val ERROR_INPUT_DUPLICATE = ERROR_TEXT + "중복하는 숫자가 존재합니다."
    const val ERROR_INPUT_RANGE = ERROR_TEXT + "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val ERROR_INPUT_BLANK_OR_CHAR = ERROR_TEXT + "문자와 공백은 입력할 수 없습니다."
    const val ERROR_INPUT_BLANK = ERROR_TEXT + "공백은 입력할 수 없습니다."
    const val ERROR_INPUT_CHAR = ERROR_TEXT + "문자는 입력할 수 없습니다."
    const val ERROR_PAY_INPUT_UNIT = ERROR_TEXT + "구입 금액은 1000 단위여야 합니다."
    const val ERROR_PAY_INPUT_MINIMUM = ERROR_TEXT + "최소 구입 금액은 1000 입니다."
    const val ERROR_PAY_INPUT_MAXIMUM = ERROR_TEXT + "최대 구입 금액은 100000 입니다."
}