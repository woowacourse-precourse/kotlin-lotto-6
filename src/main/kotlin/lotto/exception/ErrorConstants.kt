package lotto.exception

object ErrorConstants {
    const val INVALID_PRICE_FORMAT_ERROR = "[ERROR] 숫자만 입력 가능합니다."
    const val INVALID_PRICE_UNIT_ERROR = "[ERROR] 1,000원 단위의 값을 입력해주세요."
    const val INVALID_PRICE_RANGE_ERROR = "[ERROR] 1,000원 이상의 값을 입력해주세요."
    const val INVALID_LOTTO_FORMAT_ERROR = "[ERROR] 번호를 쉼표 기준으로 입력해주세요."
    const val INVALID_LOTTO_RANGE_ERROR = "[ERROR] 1~45 사이의 숫자만 가능합니다."
    const val DUPLICATE_LOTTO_ERROR = "[ERROR] 중복된 숫자는 입력할 수 없습니다."
}