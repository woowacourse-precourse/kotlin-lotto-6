package lotto.constant

enum class ErrorMessage(val message: String) {
    NOT_NUMBER_PURCHASE_AMOUNT("[ERROR] 구매금액은 정수여야 합니다."),
    NOT_PURCHASE_AMOUNT_FORMAT("[ERROR] 구매금액은 1000원단위여야 합니다."),
    NOT_BONUS_NUMBER_FORMAT("[ERROR] 보너스 금액은 정수여야 합니다."),
    NOT_NUMBER_WINNING_NUMBER("[ERROR] 당첨번호는 정수여야 합니다."),
    NOT_WINNING_NUMBER_PATTERN("[ERROR] 당첨번호의 형식에 맞게 입력해주세요."),
    NOT_SIX_WINNING_NUMBER("[ERROR] 당첨 번호는 6자리여야합니다."),
    NOT_SIX_LOTTO_NUMBER("[ERROR] Lotto 번호는 6자리여야합니다."),
    NOT_DUPLICATED_LOTTO_NUMBER("[ERROR] Lotto 번호는 6자리여야합니다."),
    NOT_DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 서로 다른 숫자여야합니다."),
    NOT_NUMBER_RANGE_WINNING_NUMBER("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야합니다."),
    NOT_NUMBER_RANGE_BONUS_NUMBER("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야합니다."),
    NOT_DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 서로 다른 숫자여야합니다.")
}