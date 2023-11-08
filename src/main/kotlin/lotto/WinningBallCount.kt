package lotto

enum class WinningBallCount(val count: Int) {
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    NOTHING(0);

    companion object {
        fun findPrizeBallCount(prize: Prize): Int {
            return when (prize) {
                Prize.FIRST -> FIRST.count
                Prize.SECOND -> SECOND.count
                Prize.THIRD -> THIRD.count
                Prize.FOURTH -> FOURTH.count
                Prize.FIFTH -> FIFTH.count
                else -> NOTHING.count
            }
        }
    }
}