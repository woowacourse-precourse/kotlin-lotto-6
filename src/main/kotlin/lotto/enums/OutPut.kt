package lotto.enums

enum class OutPut(val message: String) {
    PLEASE_INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PLEASE_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    PLEASE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    TOTAL_PROFIT_IS("총 수익률은 %.1f%%입니다"),
    WINNING_STATISTICS("당첨 통계"),
    NEW_LINE("---"),
    PURCHASED("개를 구매했습니다.")
    ;
}