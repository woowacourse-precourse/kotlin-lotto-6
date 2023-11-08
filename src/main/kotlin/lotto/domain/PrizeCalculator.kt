package lotto.domain

class PrizeCalculator(
    private val lottoList: List<Lotto>,
    winNumberList: List<Int>,
    bonusNumber: Int,
) {
    private val lottoChecker = LottoChecker(winNumber = Lotto(winNumberList), bonusNumber)

    fun getWinningCountMap() = lottoList.groupingBy {
        lottoChecker.checkLotto(it)
    }.eachCount()
    fun getSumOfWinningPrize() = lottoList.sumOf {
        val position = lottoChecker.checkLotto(it)
        position.winningPrize
    }
}