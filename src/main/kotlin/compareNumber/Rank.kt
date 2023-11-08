package compareNumber

enum class Rank {

    RANK, FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE;

    fun determineRank(winningCount: Int, input: List<Int>): Rank {
        return when (winningCount) {
            6 -> if (input.last() == 0) Rank.FIRST else Rank.SECOND
            5 -> Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}
