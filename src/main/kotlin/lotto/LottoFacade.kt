package lotto

class LottoFacade(
    private val budget: Int,
    private val winNumberList: List<Int>,
    private val bonusNumber: Int,
) {
    private val lottoBuyer = LottoBuyer(budget)
    private val lottoChecker = LottoChecker(winNumber = Lotto(winNumberList), bonusNumber)
    val lottoList = lottoBuyer.buy()

    fun getWinningCountMap() = lottoList.groupingBy {
        lottoChecker.checkLotto(it)
    }.eachCount()
    fun getSumOfWinningPrize() = lottoList.sumOf {
        val position = lottoChecker.checkLotto(it)
        position.winningPrize
    }
}
