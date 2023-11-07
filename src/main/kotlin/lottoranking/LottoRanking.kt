package lottoranking

enum class LottoRanking(val rank: Int, val reward: Int) {
    FIRST(rank = 1, reward = 2_000_000_000),
    SECOND(rank = 2, reward = 30_000_000),
    THIRD(rank = 3, reward = 1_500_000),
    FOURTH(rank = 4, reward = 50_000),
    FIFTH(rank = 5, reward = 5_000)
}
