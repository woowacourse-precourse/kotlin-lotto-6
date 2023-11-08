package lotto.enumeration

enum class WinningResult(val value: String) {
    STATISTIC("당첨 통계\n---"),
    THREE_COUNT("3개 일치 (5,000원) - "),
    FOUR_COUNT("4개 일치 (50,000원) - "),
    FIVE_COUNT("5개 일치 (1,500,000원) - "),
    FIVE_COUNT_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_COUNT("6개 일치 (2,000,000,000원) - "),
    UNIT("개"),
    ALL_EARN_RATE("총 수익률은 "),
    END_PERCENT("%입니다.");
}
