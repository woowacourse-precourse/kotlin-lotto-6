package lotto.utils

enum class Notice(val message: String) {
    PURCHASE_PAYMENT("구매금액을 입력해 주세요."),
    PURCHASED_TICKET_NUMS("개를 구매했습니다."),
    ENTER_WINNING_INFO("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_INFO("보너스 번호를 입력해 주세요.")
}