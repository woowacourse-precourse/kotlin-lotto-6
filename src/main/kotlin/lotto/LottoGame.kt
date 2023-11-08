package lotto

class LottoGame {
    private val lottoInitializer = LottoInitializer()
    private val lottoTicketPurchase = LottoTicketPurchase()
    private val lottoWinningNumbers = LottoWinningNumbers()
    private val lottoPrizeCalculator = LottoPrizeCalculator()
    private val lottoRateOfReturn = LottoRateOfReturn()
    private val printResults = PrintResults()

    fun play() {
        val (amount, lottoPurchaseCount, prizeCounts) = lottoInitializer.initializeLotto()
        val lottoPurchaseCounts = lottoTicketPurchase.purchaseLottoTickets(lottoPurchaseCount)
        val winningLotteryNumbers = lottoWinningNumbers.inputWinningNumbers()
        val bonusNumber = lottoWinningNumbers.inputBonusNumber()
        val updatedTotalPrize = lottoPrizeCalculator.calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts, winningLotteryNumbers, bonusNumber, prizeCounts)
        val updatedRateOfReturn = lottoRateOfReturn.calculateRateOfReturn(updatedTotalPrize, amount)
        printResults.printResults(prizeCounts, updatedRateOfReturn)
    }

}