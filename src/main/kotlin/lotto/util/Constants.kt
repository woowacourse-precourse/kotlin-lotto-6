const val PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요."
const val PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다."
const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."

const val LOTTO_PRICE: Int = 1000
const val ZERO: Int = 0
const val LOTTO_MAX_NUMBER: Int = 45
const val LOTTO_MIN_NUMBER: Int = 1
const val LOTTO_SIZE = 6

const val ERROR = "[ERROR]"
const val INVALID_NUMERIC_MESSAGE = ERROR + "구입 금액은 숫자로 입력되어야 합니다."
const val INVALID_POSITIVE_MESSAGE = ERROR + "구입 금액은 양수로 입력되어야 합니다."
const val INVALID_DIVISION_MESSAGE = ERROR + "구입 금액은 " + LOTTO_PRICE + "으로 나누어 떨어져야 합니다."
const val INVALID_WINNING_NUMBER_SIZE_MESSAGE = ERROR + "당첨 번호의 크기는 " + LOTTO_SIZE + "이어야 합니다."
const val INVALID_WINNING_NUMBER_NUMERIC_MESSAGE = ERROR + "당첨 번호는 숫자로 입력되어야 합니다."
const val INVALID_WINNING_NUMBER_RANGE_MESSAGE =
    ERROR + "당첨 번호는 " + LOTTO_MIN_NUMBER + "에서 " + LOTTO_MAX_NUMBER + "사이의 값이어야 합니다."

const val SPLIT_COMMA = ","