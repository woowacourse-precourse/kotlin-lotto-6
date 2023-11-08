package lottoranking

enum class LottoRanking(val correct: Int, val reward: Int, var count: Int) {
    FIFTH(correct = 3, reward = 5000, count = 0),
    FOURTH(correct = 4, reward = 50_000, count = 0),
    THIRD(correct = 5, reward = 1_500_000, count = 0),
    SECOND(correct = 5, reward = 30_000_000, count = 0),
    FIRST(correct = 6, reward = 2_000_000_000, count = 0),
}
