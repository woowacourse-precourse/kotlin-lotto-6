package lotto

data class WinCount(
    var winningCount: Int = 0,
    var bonusJudge: Boolean = false
) {
    init {
        require(winningCount in WINNING_VALID_RANGE)
    }

    companion object {
        val WINNING_VALID_RANGE = 0..6
    }
}