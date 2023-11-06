package lotto

enum class Prize(val amount: Int) {
    First(2_000_000_000),
    Second(30_000_000),
    Third(1_500_000),
    Fourth(50_000),
    Fifth(5_000),
    Nothing(0);

    companion object {
        fun findPrizeResult(matchedNumberCount: Int, hasBonusNumber: Boolean): Prize {
            return when (matchedNumberCount) {
                6 -> First
                5 -> if (hasBonusNumber) Second else Third
                4 -> Fourth
                3 -> Fifth
                else -> Nothing
            }
        }

        fun findPrizeMatchNumberCount(prize: Prize): Int {
            return when (prize) {
                First -> 6
                Second -> 5
                Third -> 5
                Fourth -> 4
                Fifth -> 3
                else -> 0
            }
        }
    }
}