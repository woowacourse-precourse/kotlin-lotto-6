package lotto.data.model

data class UserLottoState(
    var lottoTickets: List<List<Int>>,
    var firstPrizeCount: Int = 0,
    var secondPrizeCount: Int = 0,
    var thirdPrizeCount: Int = 0,
    var fourthPrizeCount: Int = 0,
    var fifthPrizeCount: Int = 0,
    var totalPrizeAmount: Int = 0,
    var totalPrizeRate: Double = 0.0,
)
