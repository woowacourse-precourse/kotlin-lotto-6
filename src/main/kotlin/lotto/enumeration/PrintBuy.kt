package lotto.enumeration

enum class PrintBuy(val value: String) {
    PRICE("구입금액을 입력해 주세요."),
    ERROR_NOT_INTEGER("[ERROR] 구입 금액은 정수여야 합니다."),
    ERROR_NOT_THOUSAND("[ERROR] 구입 금액은 1000원 단위여야 합니다.")
}
