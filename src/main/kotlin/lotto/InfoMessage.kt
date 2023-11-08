package lotto

enum class InfoMessage(val message: String) {
    PURCHASE_INSTRUCTION("구입금액을 입력해 주세요."),
    PURCHASE_TICKET_COUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WIN_STATICS("당첨 통계"),
    STATICS_DIVIDER("---"),
    BONUS_NUMBER_MATCH(", 보너스 볼 일치 "),
    TOTAL_PROFIT("총 수익률은 %.1f%%입니다.");
}