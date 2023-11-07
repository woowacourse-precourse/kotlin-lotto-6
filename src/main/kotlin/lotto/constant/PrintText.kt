package lotto.constant

enum class PrintText(val text: String) {
    REQUIRE_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_PURCHASE_AMOUNT("개를 구매했습니다."),
    REQUIRE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    SEPARATE_SAME_COUNT(" - "),
    SEPARATE_LOTTES("\n"),
    PRINT_RESULT("당첨 통계"),
    SEPARATE_RESULT("---"),
    SAME_NUMBER_COUNT("개"),
    PRINT_EARNING_RATE("총 수익률은 "),
    PRINT_PERCENT("%입니다.")
}