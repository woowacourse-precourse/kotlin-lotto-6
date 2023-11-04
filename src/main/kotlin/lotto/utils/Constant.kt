package lotto.utils

object Constant {
    // 요구 사항 상수
    const val LOTTO_COST = 1000
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_SIZE = 6
    // 출력 메시지
    const val PURCHASE_AMOUNT_MESSAGE = "구매 금액을 입력해 주세요."
    const val LOTTO_QUANTITY_MESSAGE = "\n%d개를 구매했습니다."
    const val LOTTO_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    const val WINNING_STATISTICS_HEADER_MESSAGE = "\n당첨 통계\n---"
    const val MATCH_PRIZE_MESSAGE = "%d개 일치 (%s원) - %d개"
    const val MATCH_PRIZE_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    const val YIELD_MESSAGE = "총 수익률은 %.1f%%입니다."

    // 에러 메시지
    const val PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE = "[ERROR] 구매 금액을 잘못 입력하셨습니다."
    const val AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 숫자가 나누어 떨어지지 않습니다."
    const val INVALID_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다."
    const val WINNING_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수가 잘못 입력되었거나 중복되었습니다."
    const val DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스는 중복 될 수 없습니다."
    const val INVALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다."
}
