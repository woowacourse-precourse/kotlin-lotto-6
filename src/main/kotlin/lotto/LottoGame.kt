package lotto

class LottoGame {
    private val userInput = UserInput()
    private val lottoCalculator = LottoCalculator()
    private val lottoFactory = LottoFactory()
    private val lottoGamePrinter = LottoGamePrinter()
    fun gamePlay() {
        val purchasedAmount = userInput.purchasedAmountInput()

        val lottoCount = lottoCalculator.calLottoCount(purchasedAmount)
        val lottoList = lottoFactory.createLottoByCount(lottoCount)
        lottoGamePrinter.showLottoList(lottoCount, lottoList)

        val winningList = userInput.winningPriceInput()
        val bonusNumber = userInput.bonusNumberInput(winningList)

        val winningRate = lottoCalculator.calWinningRate(lottoList, winningList, bonusNumber)
        lottoGamePrinter.showWinningRate(winningRate)

        val profitRate = lottoCalculator.calProfitRate(winningRate, purchasedAmount)
        println(LottoGameMessage.TOTAL_RATE.format(profitRate))
    }
}