package lotto

class PrizeCalculator(private val lottoList: List<Lotto>, private val lottoChecker: LottoChecker) {
    fun getSumOfWinningPrize() = lottoList.sumOf {
        val position = lottoChecker.checkLotto(it)
        position.winningPrize
    }
}
