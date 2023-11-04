package util

enum class ErrorMessage(val message: String) {
    INVALID_INPUT("공백 또는 숫자 이외의 입력은 불가능합니다."),
    INSUFFICIENT_PURCHASE_AMOUNT("로또 구입 금액은 1,000원 이상부터 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("로또 구입 금액은 1,000원 단위로 입력 가능합니다."),
}