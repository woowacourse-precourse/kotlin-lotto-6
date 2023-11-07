package lotto

class LottoGame {
    private val userInput = UserInput()
    private val lottoCalculator = LottoCalculator()
    private val lottoFactory = LottoFactory()
    private val lottoPrinter = LottoPrinter()
    fun gamePlay() {
        val purchasedAmount = userInput.purchasedAmountInput()

        val lottoCount = lottoCalculator.calLottoCount(purchasedAmount)
        val lottoList = lottoFactory.createLottoByCount(lottoCount)

        lottoPrinter.showLottoList(lottoCount, lottoList)

        val winningList = userInput.winningPriceInput()

        val bonusNumber = userInput.bonusNumberInput(winningList)

        val winningRate = lottoCalculator.calWinningRate(lottoList, winningList, bonusNumber)
        lottoCalculator.showWinningRate(winningRate)

        val profitRate = lottoCalculator.calProfitRate(winningRate, purchasedAmount)
        println(LottoGameMessage.TOTAL_RATE.format(profitRate))
    }
}