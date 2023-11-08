package lotto.model

enum class WinningRank(val prize: Int, val content: String) {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(50_000, "4개 일치 (50,000원)"),
    FIFTH(5_000, "3개 일치 (5,000원)"),
    FAILURE(0, "꽝")
}