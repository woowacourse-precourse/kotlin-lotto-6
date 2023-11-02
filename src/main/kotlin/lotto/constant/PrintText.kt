package lotto.constant

enum class PrintText(val text: String) {
    REQUIRE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_PURCHASE_AMOUNT("개를 구매했습니다."),
    REQUIRE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요.")
}