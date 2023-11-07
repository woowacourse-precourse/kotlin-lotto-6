package lotto.util

class Constants {
    companion object {
        // 출력 메시지
        const val INPUT_PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해주세요."
        const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해주세요."
        const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요."
        const val OUTPUT_LOTTO_COUNT = "당첨 통계"
        const val OUTPUT_PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다."
        const val MATCH_PRIZE_MESSAGE = "%d개 일치 (%s원) - %d개"
        const val MATCH_PRIZE_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
        const val OUTPUT_RETURN_RATE_PERCENTAGE_MESSAGE = "총 수익률은 %.1f%%입니다."

        // 상금 정보
        const val FIRST_REWARD_PRICE = 2_000_000_000
        const val SECOND_REWARD_PRICE = 30_000_000
        const val THIRD_REWARD_PRICE = 1_500_000
        const val FOURTH_REWARD_PRICE = 50_000
        const val FIFTH_REWARD_PRICE = 5_000

        // 당첨 정보
        const val FIRST_REWARD_MATCHED_COUNT = 6
        const val SECOND_REWARD_MATCHED_COUNT = 5
        const val THIRD_REWARD_MATCHED_COUNT = 5
        const val FOURTH_REWARD_MATCHED_COUNT = 4
        const val FIFTH_REWARD_MATCHED_COUNT = 3

        // 상금 문자열 포맷
        const val FIRST_REWARD_PRIZE = "2,000,000,000"
        const val SECOND_REWARD_PRIZE = "30,000,000"
        const val THIRD_REWARD_PRIZE = "1,500,000"
        const val FOURTH_REWARD_PRIZE = "50,000"
        const val FIFTH_REWARD_PRIZE = "5,000"

        // 요구사항 상수
        const val LOTTO_PRICE = 1000
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_SIZE = 6
        const val PERCENT = 100

        // 에러 메시지 표현
        const val INPUT_IS_NUMBER_ERROR_MESSAGE = "[ERROR] 입력은 모두 숫자여야 합니다."
        const val PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE = "[ERROR] 구매 금액을 잘못 입력하셨습니다."
        const val AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 숫자가 나누어 떨어지지 않습니다."
        const val INVALID_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다."
        const val WINNING_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val DUPLICATE_WINNING_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 당첨 번호의 개수가 잘못 입력되었거나 중복되었습니다."
        const val DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스는 중복 될 수 없습니다."
        const val INVALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다."
    }
}