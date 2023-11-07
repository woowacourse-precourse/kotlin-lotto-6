package lotto.model

class Lottoes(val userNumbers: Set<Int>, val bonusNumber: Int, val paymentAmount: String) {

    private lateinit var lottoes: List<Lotto>
    private lateinit var lottoesResult: Map<WinningRank, Int>
    private var lottoTicketCount: Int = paymentAmount.toInt() / 1000


    fun calculateLottoesResult(): Map<WinningRank, Int> {
        return mapOf()
    }

    fun getTotalProfit(): Profit {
        return Profit()
    }
}