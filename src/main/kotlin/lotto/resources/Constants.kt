package lotto.resources

object Comment {
    const val ENTER_PURCHASE_AMOUNT_COMMENT = "구입금액을 입력해 주세요."
    const val ENTER_WINNING_NUMBERS_COMMENT = "\n당첨 번호를 입력해 주세요."
    const val ENTER_BONUS_NUMBERS_COMMENT = "\n보너스 번호를 입력해 주세요."
    const val WINNING_STATS_COMMENT = "당첨통계\n---"

    fun lottoCountComment(count: Int) = "\n${count}개를 구매했습니다."

    fun totalRateComment(rate: String) = "총 수익률은 ${rate}%입니다."
}

object Lotto {
    const val INIT_VALUE = 0

    const val LOTTO_PRISE = 1000

    const val MATCH_SIX_PRISE = 2000000000.0
    const val MATCH_FIVE_WITH_BONUS_PRISE = 30000000.0
    const val MATCH_FIVE_PRISE = 1500000.0
    const val MATCH_FOUR_PRISE = 50000.0
    const val MATCH_THREE_PRISE = 5000.0

    const val START_NUMBER = 1
    const val END_NUMBER = 45
    const val LOTTO_NUMBERS_COUNT = 6
}

object Error {
    const val CANT_BUY_ERROR = "[ERROR] 1,000원 미만으로는 로또를 구매하실 수 없습니다."
    const val NOT_INT_ERROR = "[ERROR] 정수만 입력할 수 있습니다."
    const val NOT_IN_LOTTO_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val CANT_CONTAIN_WINNING_NUMBER_ERROR ="[ERROR] 당첨 번호와 겹치는 숫자는 입력할 수 없습니다."
    const val MISMATCHED_UNIT_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."
    const val WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 총 6개여야 합니다."
}