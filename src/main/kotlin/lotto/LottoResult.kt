package lotto

data class LottoResult(
    var winningCount: Int = 0,
    var bonusJudge: Boolean = false
) {
    init {
        require(winningCount in WINNING_VALID_RANGE) { Message.ERROR_WIN_COUNT_CALCULATOR }
    }

    companion object {
        val WINNING_VALID_RANGE = 0..6
    }
}