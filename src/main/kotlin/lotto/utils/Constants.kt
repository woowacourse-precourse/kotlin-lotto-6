package lotto.utils

object Constants {
    const val PURCHASED_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요."
    const val PURCHASED_MONEY_MIN_ERROR_MESSAGE = "[ERROR] 구입금액은 0원 이상이여야 합니다."
    const val PURCHASED_MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입금액은 1000원 단위여야 합니다."
    const val LOTTO_PURCHASED_COUNT_MESSAGE = "\n%d개를 구매했습니다."
    const val WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요."
    const val BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요."
    const val WINNING_STATISTICS_INFO_MESSAGE = "당첨 통계\n---"
    const val WINNING_STATISTICS_MESSAGE = "%d개 일치 (%s원) - %d개"
    const val WINNING_STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    const val TOTAL_EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
    const val LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자여야 합니다."
    const val LOTTO_NUMBER_TYPE_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다."
    const val LOTTO_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."
    const val MONEY_UNIT = 1000
    const val MIN_MONEY = 0
    const val MIN_LOTTO_NUMBER_RANGE = 1
    const val MAX_LOTTO_NUMBER_RANGE = 45
    const val LOTTO_NUMBER_COUNT = 6
    const val FIRST_RANK_PRIZE_MONEY = 2_000_000_000
    const val FIRST_RANK_MATCH_COUNT = 6
    const val SECOND_RANK_PRIZE_MONEY = 30_000_000
    const val SECOND_AND_THIRD_RANK_MATCH_COUNT = 5
    const val THIRD_RANK_PRIZE_MONEY = 1_500_000
    const val FOURTH_RANK_PRIZE_MONEY = 50_000
    const val FOURTH_RANK_MATCH_COUNT = 4
    const val FIFTH_RANK_PRIZE_MONEY = 5_000
    const val FIFTH_RANK_MATCH_COUNT = 3
    const val NONE_MATCH_COUNT = 0
    const val NONE_PRIZE_MONEY = 0
    const val LOTTO_MIN_COUNT = 0
    const val LOTTO_COUNT_PLUS_UNIT = 1
    const val BONUS_NUMBER_INIT = 1
}