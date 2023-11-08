package lotto

enum class MatchCatalog(private var matchCount: Int) {
    Match3(0), Match4(0),
    Match5(0), MatchBonus(0),
    Match6(0);

    fun matchCountPlus() = matchCount++
    fun getMatchCount() = matchCount
}