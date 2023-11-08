package lotto

class Constants {
    companion object {
        const val LOTTO_PRICE = 1000
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.\n"
        const val OUTPUT_PURCHASE_NUMBER_MESSAGE = "%d개를 구매했습니다.\n"
        const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.\n"
        const val INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.\n"
        const val OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n"
        const val OUTPUT_LINES = "---\n"
        const val OUTPUT_THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - %d개\n"
        const val OUTPUT_FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - %d개\n"
        const val OUTPUT_FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - %d개\n"
        const val OUTPUT_FIVE_WITH_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
        const val OUTPUT_SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n"
        const val OUTPUT_PROFIT_PERCENTAGE_MESSAGE = "총 수익률은 %.1f%%입니다."
        const val ERROR_INVALID_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 알맞는 금액을 입력해주세요.(구입 금액은 1,000원 단위로 입력)"
        const val ERROR_OUT_OF_RANGE_NUMBER_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해 주세요."
        const val ERROR_INVALID_PURCHASE_NUMBER_MESSAGE = "[ERROR] 총 6개의 숫자를 입력해 주세요."
        const val ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 서로 다른 숫자여야합니다."
        const val ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
    }
}
