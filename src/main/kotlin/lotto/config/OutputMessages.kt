package lotto.config


enum class OutputMessages(val message: String) {
    PURCHASE_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_CONFIRMATION("%d개를 구매했습니다."),
    RIGHT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    DIVIDING_LINE_LARGE("---"),
    DIVIDING_LINE_SMALL("-"),
    LOTTO_COUNT("개"),
    THREE_NUMBER_CORRECT("3개 일치 (5,000원)"),
    FOUR_NUMBER_CORRECT("4개 일치 (50,000원)"),
    FIVE_NUMBER_CORRECT("5개 일치 (1,500,000원)"),
    FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_NUMBER_CORRECT("6개 일치 (2,000,000,000원)"),
    YIELD_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.")
 }