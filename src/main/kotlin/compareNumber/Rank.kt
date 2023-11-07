package compareNumber

enum class Rank {
    RANK,FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE;

    fun determineRank(result:  List<Int>): Rank {
        val matchingNumbers = result.count() { it == 1}
        return when (matchingNumbers) {
            6 -> if (result.last() == 0) Rank.FIRST else Rank.SECOND
            5 -> Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}
