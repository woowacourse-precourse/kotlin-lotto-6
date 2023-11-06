package lotto

class PrizeCalculator(private val lottoList: List<Lotto>, private val lottoChecker: LottoChecker) {
    fun getWinningCountMap() = lottoList.groupingBy {
        lottoChecker.checkLotto(it)
    }.eachCount()
    fun getSumOfWinningPrize() = lottoList.sumOf {
        val position = lottoChecker.checkLotto(it)
        position.winningPrize
    }
}
