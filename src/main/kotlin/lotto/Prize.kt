package lotto

enum class Prize {
    First,
    Second,
    Third,
    Fourth,
    Fifth,
    Nothing;

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
    }
}