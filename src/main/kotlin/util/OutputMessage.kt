package util

enum class OutputMessage(val message: String) {
    PURCHASE_AMOUNT_INSTRUCTION("구입금액을 입력해 주세요."),
    ERROR_MESSAGE("[ERROR] %s"),
    NUMBER_OF_PURCHASES("\n%d개를 구매했습니다."),
    WINNING_NUMBER_INSTRUCTION("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INSTRUCTION("\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_INSTRUCTION("\n당첨 통계\n---"),
    WINNING_FIFTH_RANK("3개 일치 (5,000원) - %d개"),
    WINNING_FOURTH_RANK("4개 일치 (50,000원) - %d개"),
    WINNING_THIRD_RANK("5개 일치 (1,500,000원) - %d개"),
    WINNING_SECOND_RANK("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    WINNING_FIRST_RANK("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.")
}