package lotto.domain.enum.winning

enum class RankCount(val rank: Int, val count: Int) {
    FIRST(1, 6),
    SECOND(2, 5),
    THIRD(3, 5),
    FOURTH(4, 4),
    FIFTH(5, 3),
    NOT(6, 0)
}