package util

enum class PrizeMessageRank(val rank: Int, val matchingCount: Int, val prize: Long, val message: String) {
    FIRST(1, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - result개"),
    SECOND(2, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - result개"),
    THIRD(3, 5, 1_500_000, "5개 일치 (1,500,000원) - result개"),
    FOURTH(4, 4, 50_000, "4개 일치 (50,000원) - result개"),
    FIFTH(5, 3, 5_000, "3개 일치 (5,000원) - result개"),
}
