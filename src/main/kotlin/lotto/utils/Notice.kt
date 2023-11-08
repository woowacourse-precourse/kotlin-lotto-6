package lotto.utils

enum class Notice(val message: String) {
    PURCHASE_PAYMENT("구입금액을 입력해 주세요."),
    PURCHASED_TICKET_NUMS("개를 구매했습니다."),
    ENTER_WINNING_INFO("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_INFO("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    HYPHENS("---"),
    COUNT("개"),
    PRESENT_RATE_FIRST("총 수익률은 "),
    PRESENT_RATE_SECOND("%입니다.");


}