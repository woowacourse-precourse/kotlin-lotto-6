package lotto

class LottoMachine(private val amount: String = "") {

    private val outputView = OutputView()
    private val lottoGenerator = LottoGenerator()
    private var allLotto = mutableListOf<List<Int>>()

    fun calculateLottoQuantity(): Int {
        return amount.toInt() / PRICE_LOTTO
    }

    fun printNumbers(quantity: Int): List<List<Int>> {
        repeat(quantity) {
            val numbers = lottoGenerator.generateLotto()
            allLotto.add(numbers)
            outputView.printLottoNumbers(numbers)
        }
        return allLotto
    }

    fun calculateMatchResults(
        allLotto: List<List<Int>>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ): List<Pair<Int, Boolean>> {
        return allLotto.map { lotto ->
            val matchCount = lotto.count { it in winningNumbers }
            val hasBonus = bonusNumber in lotto
            matchCount to hasBonus
        }
    }

    fun tallyResults(results: List<Pair<Int, Boolean>>): Map<Jackpot?, Int> {
        return results.groupingBy { Jackpot.findByMatchInfo(it.first, it.second) }.eachCount()
    }

    fun getWinningDetails(stats: Map<Jackpot?, Int>): List<String> {
        val winningDetails = mutableListOf<String>()

        Jackpot.entries.forEach { jackpot ->
            val count = stats[jackpot] ?: 0
            val winningDetail = if (jackpot.bonusMatch) {
                "${jackpot.countMatches}개 일치, 보너스 볼 일치 (${Jackpot.format(jackpot.jackpot)}원) - ${count}개"
            } else {
                "${jackpot.countMatches}개 일치 (${Jackpot.format(jackpot.jackpot)}원) - ${count}개"
            }
            winningDetails.add(winningDetail)
        }

        return winningDetails
    }

    companion object {
        const val PRICE_LOTTO = 1000
    }

}