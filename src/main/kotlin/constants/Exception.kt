package constants

object Exception {
    const val LOTTO_NUMBER_SIZE_ERROR = "로또 번호는 6개여야 합니다."
    const val LOTTO_NUMBER_DUPLICATE_ERROR = "로또 번호에 중복된 숫자가 있으면 안됩니다."
    const val LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 1부터 45사이의 숫자여야합니다."
    const val PURCHASE_AMOUNT_UNIT_ERROR = "[ERROR] 구입 금액의 단위는 1,000원 단위입니다."
    const val PURCHASE_AMOUNT_NUMBER_ERROR = "[ERROR] 유효하지 않은 입력입니다. 구입 금액은 숫자여야 합니다."
    const val INVALID_ERROR = "[ERROR] 1부터 45 사이의 6개의 서로 다른 숫자를 입력해야 합니다."
    const val INVALID_BONUS_NUMBER_ERROR = "[ERROR] 1부터 45 사이의 숫자이며, 당첨 번호와 겹치지 않는 숫자를 입력해야 합니다."
}