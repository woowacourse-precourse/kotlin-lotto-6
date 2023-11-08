package lotto.util

object Constants {

    //INPUT
    const val INPUT_MONEY = "구입금액을 입력해 주세요."
    const val INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요."
    const val INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요."

    //OUTPUT
    const val OUTPUT_NUMBER = "개를 구매했습니다."
    const val WINNING_STATISTICS = "당첨 통계"
    const val SEPARATOR = "---"

    //WINNING
    const val MATCH_THREE = "3개 일치 (5,000원) - "
    const val MATCH_FOUR = "4개 일치 (50,000원) - "
    const val MATCH_FIVE = "5개 일치 (1,500,000원) - "
    const val MATCH_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
    const val MATCH_SIX = "6개 일치 (2,000,000,000원) - "

    //ERROR
    const val INPUT_BLANK_OR_STRING_ERROR = "[ERROR] 숫자만 입력 가능합니다."
    const val INPUT_WRONG_UNIT_ERROR = "[ERROR] 금액은 1,000원 단위로만 입력 가능합니다."
    const val INPUT_WRONG_LENGTH_ERROR = "[ERROR] 로또 번호는 6개의 숫자입니다."
    const val INPUT_WRONG_RANGE_ERROR = "[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."
    const val DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."
    const val DUPLICATE_WITH_LOTTO_ERROR = "[ERROR] 로또 번호와 중복되는 번호입니다."

}