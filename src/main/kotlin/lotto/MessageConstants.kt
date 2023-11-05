package lotto

object MessageConstants {
    const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    const val ERROR_AMOUNT_LESS_THAN_1000 = "[ERROR] 1000 이상의 금액을 입력하세요."
    const val ERROR_NOT_A_MULTIPLE_OF_1000 = "[ERROR] 1000으로 나누어 떨어지는 값을 입력하세요."
    const val ERROR_NOT_A_NUMBER = "[ERROR] 숫자를 입력하세요."
    const val PURCHASE_COMPLETED = "개를 구매했습니다."
    const val ERROR_NOT_6_NUMBERS = "[ERROR] 6개의 숫자를 입력하세요."
    const val ERROR_DUPLICATE_NUMBER = "[ERROR] 중복되는 숫자가 없어야 합니다."
    const val ERROR_LESS_THAN_1_OR_MORE_THAN_45 = "[ERROR] 1부터 45 사이의 숫자만 입력하세요."
    const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
    const val ERROR_NOT_ALL_NUMBERS = "[ERROR] 당첨 번호는 모두 숫자여야 합니다."
    const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    const val DUPLICATE_WINNING_AND_BONUS_NUMBER = "[ERROR] 기존 당첨 번호에 이미 같은 값이 있습니다."
    const val BONUS_NUMBER_IS_NOT_A_NUMBER = "[ERROR] 보너스 번호는 숫자여야 합니다."
    const val THREE_MATCHES = "3개 일치 (5,000원)"
    const val FOUR_MATCHES = "4개 일치 (50,000원)"
    const val FIVE_MATCHES = "5개 일치 (1,500,000원)"
    const val FIVE_MATCHES_AND_BONUS_NUMBER_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원)"
    const val SIX_MATCHES = "6개 일치 (2,000,000,000원)"
    const val WINNING_STATISTICS = "\n당첨 통계\n---"
    const val UNIT = "개"
    const val YIELD_MESSAGE_START = "총 수익률은 "
    const val YIELD_MESSAGE_END = "%입니다."

}