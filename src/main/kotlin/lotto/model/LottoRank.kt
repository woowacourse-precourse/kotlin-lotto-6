package lotto.model

enum class LottoRank(val rank: Int, val reward: Int, val message: String) {
    NOT_IN_RANK(rank = 6, reward = 0, message = ""),
    FIFTH_RANK(rank = 5, reward = 5000, message = "3개 일치 (5,000원) - "),
    FOURTH_RANK(rank = 4, reward = 50000, message = "4개 일치 (50,000원) - "),
    THIRD_RANK(rank = 3, reward = 1500000, message = "5개 일치 (1,500,000원) - "),
    SECOND_RANK(rank = 2, reward = 30000000, message = "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_RANK(rank = 1, reward = 2000000000, message = "6개 일치 (2,000,000,000원) - "),
}