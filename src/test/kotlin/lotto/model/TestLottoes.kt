package lotto.model

class TestLottoes(private val userNumbers: Set<Int>, private val bonusNumber: Int, paymentAmount: String) :
    Lottoes {

    var lottoes: MutableList<Lotto> = mutableListOf()
    private var lottoesResult: MutableMap<WinningRank, Int> =
        WinningRank.values().associateWith { 0 }.toMutableMap()


    override fun calculateLottoesResult(): Map<WinningRank, Int> {
        lottoes.forEach {
            val numMatchCount = it.calculateMatchingCount(userNumbers)
            val bonusNumberMatch = it.containBonusNumber(bonusNumber)
            val result = it.calculateLottoRank(numMatchCount, bonusNumberMatch)

            lottoesResult[result] = (lottoesResult[result] ?: 0) + 1
        }
        return lottoesResult
    }

    override fun getTotalProfit(): Profit = Profit(0)


}