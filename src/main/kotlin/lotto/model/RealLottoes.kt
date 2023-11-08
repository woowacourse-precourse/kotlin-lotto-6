package lotto.model

class RealLottoes(private val userNumbers: Set<Int>, private val bonusNumber: Int, paymentAmount: String) : Lottoes {

    private var lottoes: MutableList<Lotto> = mutableListOf()
    private var lottoTicketCount: Int = paymentAmount.toInt() / 1000
    private var lottoesResult: MutableMap<WinningRank, Int> =
        WinningRank.values().associateWith { 0 }.toMutableMap()
    private var lottoGenerator: LottoGenerator = LottoGenerator()

    init {
        for (i in 1..lottoTicketCount) {
            lottoes.add(lottoGenerator.generateLotto())
        }
    }


    override fun calculateLottoesResult(): Map<WinningRank, Int> {
        lottoes.forEach {
            val numMatchCount = it.calculateMatchingCount(userNumbers)
            val bonusNumberMatch = it.containBonusNumber(bonusNumber)
            val result = it.calculateLottoRank(numMatchCount, bonusNumberMatch)

            lottoesResult[result] = (lottoesResult[result] ?: 0) + 1
        }
        return lottoesResult
    }

    override fun getProfitRate(): Double {
        val profitAmount = calculateTotalProfit()
        val profit = Profit(profitAmount)
        return profit.profitRate
    }

    private fun calculateTotalProfit(): Int =
        lottoesResult.entries.sumOf { (rank, count) ->
            rank.prize * count
        }

}