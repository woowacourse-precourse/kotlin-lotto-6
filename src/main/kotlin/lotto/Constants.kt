package lotto

object Constants {
    const val REQUEST_BUYING_MESSAGE = "구입금액을 입력해 주세요."
    const val REQUEST_PICKING_WINNING_MESSAGE = "당첨 번호를 입력해 주세요."
    const val REQUEST_PICKING_BONUS_MESSAGE = "보너스 번호를 입력해 주세요."
    const val RESULT_BUYING_COUNT_MESSAGE = "개를 구매했습니다."

    const val ERROR_BLANK_MESSAGE = "값이 입력되지 않았습니다."
    const val ERROR_NUMBER_FORMAT_MESSAGE = "입력값은 숫자로만 이루어져야 합니다. (구분자 제외)"
    const val ERROR_SEPARATOR_MESSAGE = "구분자 형태가 올바르지 않습니다."
    const val ERROR_MONEY_NUMBER_MINIMUM_MESSAGE = "구입 금액은 최소 1 이상의 숫자 이여야 합니다."
    const val ERROR_MONEY_NUMBER_DIVIDE_MESSAGE = "구입 금액은 1000 으로 나누어 떨어져야 합니다."
    const val ERROR_LOTTO_NUMBER_COUNT_MESSAGE = "로또 번호의 개수는 6개 이여야 합니다."
    const val ERROR_LOTTO_NUMBER_DISTINCTION_MESSAGE = "로또 번호는 서로 중복되지 않은 숫자 이여야 합니다."
    const val ERROR_LOTTO_NUMBER_BOUNDARY_MESSAGE = "로또 번호는 1 부터 45 사이의 숫자 이여야 합니다."
    const val ERROR_BONUS_NUMBER_DISTINCTION_MESSAGE = "보너스 번호는 당첨 번호와 중복되지 않아야 합니다."

    const val RESULT_WINNING_TITLE = "\n당첨 통계\n---"
    const val RESULT_WINNING_CASE_1 = "\n3개 일치 (5,000원)"
    const val RESULT_WINNING_CASE_2 = "\n4개 일치 (50,000원)"
    const val RESULT_WINNING_CASE_3 = "\n5개 일치 (1,500,000원)"
    const val RESULT_WINNING_CASE_4 = "\n5개 일치, 보너스 볼 일치 (30,000,000원)"
    const val RESULT_WINNING_CASE_5 = "\n6개 일치 (2,000,000,000원)"
    const val RESULT_WINNING_MARGIN_HEADER = "총 수익률은 "
    const val RESULT_WINNING_MARGIN_FOOTER = "입니다."

    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_NUMBER_COUNT = 6
    const val CASE_1_WINNINGS = 5000
    const val CASE_2_WINNINGS = 50000
    const val CASE_3_WINNINGS = 1500000
    const val CASE_4_WINNINGS = 30000000
    const val CASE_5_WINNINGS = 2000000000

    const val ERROR = "[ERROR] "
    const val BRIDGE = " - "
    const val COUNT_UNIT = "개"
    const val COMMA = ","
    const val PERCENT = "%"
    const val THOUSAND = 1000
    const val ZERO = 0
}