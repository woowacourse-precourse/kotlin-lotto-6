package lotto

enum class Rank(val winnerPrize: Int, val rank: Int, val message: String) {
    FIRST(2000000000, 1, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, 2, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, 3, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, 4, "4개 일치 (50,000원) - "),
    FIFTH(5000, 5, "3개 일치 (5,000원) - "),
    NO_PRIZE(0, 0, "")
}