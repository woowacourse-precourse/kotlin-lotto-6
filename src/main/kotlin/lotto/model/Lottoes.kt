package lotto.model

class Lottoes(private val paymentAmount: Int) {

    var userNumbers: Set<Int> = setOf()
    var bonusNumber: Int = 0
    var lottoes: MutableList<Lotto> = mutableListOf()

    val lottoTicketCount: Int = paymentAmount / 1000
    private var lottoGenerator: LottoGenerator = LottoGenerator()
    private var lottoesResult: MutableMap<WinningRank, Int> =
        WinningRank.values().associateWith { 0 }.toMutableMap()

    init {
        for (i in 1..lottoTicketCount) {
            lottoes.add(lottoGenerator.generateLotto())
        }
    }


    fun calculateLottoesResult(): Map<WinningRank, Int> {
        lottoes.forEach {
            val numMatchCount = it.calculateMatchingCount(userNumbers)
            val bonusNumberMatch = it.containBonusNumber(bonusNumber)
            val result = it.calculateLottoRank(numMatchCount, bonusNumberMatch)

            lottoesResult[result] = (lottoesResult[result] ?: 0) + 1
        }
        return lottoesResult
    }

    fun getProfitRate(): Double {
        val profitAmount = calculateTotalProfit()
        val profit = Profit(profitAmount)
        return profit.calculateProfitRate(paymentAmount)
    }

    internal fun calculateTotalProfit(): Int =
        lottoesResult.entries.sumOf { (rank, count) ->
            rank.prize * count
        }

}