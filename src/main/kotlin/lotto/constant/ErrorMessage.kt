package lotto.constant

enum class ErrorMessage(val message: String) {
    NOT_NUMBER_PURCHASE_AMOUNT("[ERROR] 구매금액은 정수여야 합니다."),
    NOT_NUMBER_WINNING_NUMBER("[ERROR] 당첨번호는 정수여야 합니다.")
}