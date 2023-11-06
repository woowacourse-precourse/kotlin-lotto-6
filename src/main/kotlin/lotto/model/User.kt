package lotto.model

class User() {
    private var _money: Int = 0
    var money: Int = _money

    private var _lottoTickets = listOf<Lotto>()
    var lottoTickets = _lottoTickets

    private val _lottoResult = mutableMapOf(
        THREE_MATCH to 0,
        FOUR_MATCH to 0,
        FIVE_MATCH to 0,
        FIVE_AND_BONUS_MATCH to 0,
        SIX_MATCH to 0,
    )
    val lottoResult = _lottoResult

    private var _totalPrize = 0
    var totalPrize = _totalPrize

    fun setResult(key: String) {
        val currentValue = _lottoResult[key] ?: 0
        _lottoResult[key] = currentValue + 1
    }

    companion object {
        const val THREE_MATCH = "3개 일치 (5,000원) - "
        const val FOUR_MATCH = "4개 일치 (50,000원) - "
        const val FIVE_MATCH = "5개 일치 (1,500,000원) - "
        const val FIVE_AND_BONUS_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - "
        const val SIX_MATCH = "6개 일치 (2,000,000,000원) - "

        const val THREE_MATCH_REWARD = 5000
        const val FOUR_MATCH_REWARD = 50000
        const val FIVE_MATCH_REWARD = 1500000
        const val FIVE_AND_BONUS_MATCH_REWARD = 30000000
        const val SIX_MATCH_REWARD = 2000000000
    }


}
