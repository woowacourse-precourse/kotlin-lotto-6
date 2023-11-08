package lotto

object ErrorConstants {
    const val INVALID_MONEY_UNIT_ERROR = "[ERROR] 구입 금액을 1,000원 단위로 입력해주세요."
    const val INVALID_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 1부터 45까지의 숫자만 입력 가능합니다."
    const val INVALID_LOTTO_COUNT_ERROR = "[ERROR] 로또 번호 총 6개를 입력해주세요."
    const val DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다."
    const val NUMBER_FORMAT_ERROR = "[ERROR] 숫자 형식의 입력이 필요합니다."
    const val NEGATIVE_INPUT_ERROR = "[ERROR] 입력 값은 양수만 허용됩니다."
}
