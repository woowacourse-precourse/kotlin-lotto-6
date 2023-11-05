package lotto.util

object Constant {
    const val LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개의 숫자입니다."
    const val LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE = "[ERROR] 로또 번호는 겹치면 안됩니다."
    const val LOTTO_NUMBER_SORT_ERROR_MESSAGE = "[ERROR] 로또 번호는 오름차순으로 정렬되어야 합니다."
    const val LOTTO_BUY_ERROR_MESSAGE = "[ERROR] 로또 번호의 개수는 구입 금액 / 단위 가격입니다."
    const val LOTTO_MIN_RANDOM_NUMBER = 1
    const val LOTTO_MAX_RANDOM_NUMBER = 45
    const val LOTTO_NUMBER_SIZE = 6
    const val UNIT_PRICE = 1000
    const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다."
    const val INPUT_PRICE_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다."
    const val INPUT_LUCKY_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    const val INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE = "[ERROR] 당첨 번호는 겹치면 안됩니다."
    const val INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."
    const val INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개의 숫자입니다."
    const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 겹치면 안됩니다."
    const val INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."
    const val WINNING_STATISTICS_MESSAGE = "당첨 통계\n---"
    const val LOTTO_BUY_MESSAGE = "%d개를 구매했습니다."
    const val TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
    const val FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개"
    const val SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
    const val THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개"
    const val FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개"
    const val FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개"
}