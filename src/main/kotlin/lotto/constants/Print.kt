package lotto.constants

enum class Print(private val msg: String) {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    WINNING_STAT("당첨 통계"),
    DIVIDE_LINE("---"),
    MATCHING_NUMBER("%s - %d개"),
    TOTAL_RETURN("총 수익률은 %s%%입니다.");

    override fun toString() = msg
}