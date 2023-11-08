package lotto.model

class RealLottoes(val userNumbers: Set<Int>, val bonusNumber: Int, val paymentAmount: String) : Lottoes {

    private lateinit var lottoes: List<Lotto>
    private lateinit var lottoesResult: Map<WinningRank, Int>
    private var lottoTicketCount: Int = paymentAmount.toInt() / 1000
    private lateinit var lottoGenerator: LottoGenerator

    override fun calculateLottoesResult(): Map<WinningRank, Int> {
        TODO("Not yet implemented")
    }

    override fun getTotalProfit(): Profit {
        TODO("Not yet implemented")
    }
}