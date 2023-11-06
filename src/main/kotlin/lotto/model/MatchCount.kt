package lotto.model

enum class MatchCount(vararg val value: Int) {
    Six(6), Five(5), Four(4),
    Three(3), Remain(0, 1, 2)
}