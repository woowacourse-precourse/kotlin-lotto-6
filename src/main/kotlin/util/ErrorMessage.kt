package util

enum class ErrorMessage(val message: String) {
    INVALID_INPUT("공백을 입력하거나 숫자 이외의 값을 입력하는 것은 불가능합니다."),
    INSUFFICIENT_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 이상부터 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위로 입력 가능합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자만 가능합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복되지 않는 숫자만 가능합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개의 숫자만 가능합니다."),
    DUPLICATED_BONUS_NUMBER("로또 보너스 번호는 당첨 번호와 중복되지 않는 숫자만 가능합니다.")
}