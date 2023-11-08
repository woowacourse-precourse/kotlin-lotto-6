const val PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요."
const val PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다."
const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

const val LOTTO_PRICE: Int = 1000
const val ZERO: Int = 0
const val LOTTO_MAX_NUMBER: Int = 45
const val LOTTO_MIN_NUMBER: Int = 1
const val LOTTO_SIZE = 6

const val MATCH_COUNT = "%d"
const val LOTTO_FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - $MATCH_COUNT" + "개"
const val LOTTO_SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - $MATCH_COUNT" + "개"
const val LOTTO_THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - $MATCH_COUNT" + "개"
const val LOTTO_FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - $MATCH_COUNT" + "개"
const val LOTTO_FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - $MATCH_COUNT" + "개"
const val LOTTO_STATISTICS_MESSAGE = "당첨 통계\n---"

const val MATCH_SIX: Int = 6
const val MATCH_FIVE: Int = 5
const val MATCH_FOUR: Int = 4
const val MATCH_THREE: Int = 3

const val FIRST_REWARD = 2_000_000_000
const val SECOND_REWARD = 30_000_000
const val THIRD_REWARD = 1_500_000
const val FOURTH_REWARD = 50_000
const val FIFTH_REWARD = 5_000

const val ERROR = "[ERROR]"
const val INVALID_NUMERIC_MESSAGE = ERROR + " 구입 금액은 숫자로 입력되어야 합니다."
const val INVALID_POSITIVE_MESSAGE = ERROR + " 구입 금액은 양수로 입력되어야 합니다."
const val INVALID_DIVISION_MESSAGE = ERROR + " 구입 금액은 " + LOTTO_PRICE + "으로 나누어 떨어져야 합니다."
const val INVALID_WINNING_NUMBER_SIZE_MESSAGE = ERROR + " 당첨 번호의 크기는 " + LOTTO_SIZE + "이어야 합니다."
const val INVALID_WINNING_NUMBER_NUMERIC_MESSAGE = ERROR + " 당첨 번호는 숫자로 입력되어야 합니다."
const val INVALID_WINNING_NUMBER_RANGE_MESSAGE =
    ERROR + " 당첨 번호는 " + LOTTO_MIN_NUMBER + "에서 " + LOTTO_MAX_NUMBER + "사이의 값이어야 합니다."
const val INVALID_WINNING_NUMBER_DUPLICATION_MESSAGE = ERROR + " 당첨 번호는 중복되지 않은 숫자로 입력되어야 합니다."
const val INVALID_BONUS_NUMBER_NUMERIC_MESSAGE = ERROR + " 보너스 번호는 숫자로 입력되어야 합니다."
const val INVALID_BONUS_NUMBER_RANGE_MESSAGE =
    ERROR + " 보너스 번호는 " + LOTTO_MIN_NUMBER + "에서 " + LOTTO_MAX_NUMBER + "사이의 값이어야 합니다."
const val INVALID_BONUS_NUMBER_DUPLICATION_MESSAGE = ERROR + " 보너스 번호와 당첨 번호는 중복될 수 없습니다."

const val SPLIT_COMMA = ","