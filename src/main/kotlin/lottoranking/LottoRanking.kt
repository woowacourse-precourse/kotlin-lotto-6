package lottoranking

enum class LottoRanking(val rank: Int, val reward: Int, val count: Int) {
    FIRST(rank = 1, reward = 2_000_000_000, count = 0),
    SECOND(rank = 2, reward = 30_000_000, count = 0),
    THIRD(rank = 3, reward = 1_500_000, count = 0),
    FOURTH(rank = 4, reward = 50_000, count = 0),
    FIFTH(rank = 5, reward = 5_000, count = 0)
}
