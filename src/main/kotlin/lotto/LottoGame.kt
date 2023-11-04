package lotto

class LottoGame {
    private val lottoInitializer = LottoInitializer()
    private val lottoTicketPurchase = LottoTicketPurchase()
    private val lottoWinningNumbers = LottoWinningNumbers()
    private val lottoPrizeCalculator = LottoPrizeCalculator()
    private val lottoRateOfReturn = LottoRateOfReturn()
    private val printResults = PrintResults()

    fun play() {
        val (amount, lottoPurchaseCount, prizeCounts, totalPrize, rateOfReturn) = lottoInitializer.initializeLotto()
        val lottoPurchaseCounts = lottoTicketPurchase.purchaseLottoTickets(lottoPurchaseCount)
        val winningLotteryNumbers = lottoWinningNumbers.inputWinningNumbers()
        val bonusNumber = lottoWinningNumbers.inputBonusNumber(winningLotteryNumbers)
        val updatedTotalPrize = lottoPrizeCalculator.calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts, winningLotteryNumbers, bonusNumber, prizeCounts)
        val updatedRateOfReturn = lottoRateOfReturn.calculateRateOfReturn(updatedTotalPrize, amount)
        printResults.printResults(prizeCounts, updatedRateOfReturn)
    }

    //data class Tuple(val amount: Int, val lottoPurchaseCount: Int, val prizeCounts: IntArray, val totalPrize: Int, val rateOfReturn: Double)
}