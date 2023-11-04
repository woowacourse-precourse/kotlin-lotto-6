package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val (amount, lottoPurchaseCount, prizeCounts, totalPrize, rateOfReturn) = initializeLotto()
    val lottoPurchaseCounts = purchaseLottoTickets(lottoPurchaseCount)
    val winningLotteryNumbers = inputWinningNumbers()
    val bonusNumber = inputBonusNumber(winningLotteryNumbers)
    val updatedTotalPrize = calculatePrizesAndReturnTotalPrize(lottoPurchaseCounts, winningLotteryNumbers, bonusNumber, prizeCounts)
    val updatedRateOfReturn = calculateRateOfReturn(updatedTotalPrize, amount)
    printResults(prizeCounts, updatedRateOfReturn)
}

data class Tuple(val amount: Int, val lottoPurchaseCount: Int, val prizeCounts: IntArray, val totalPrize: Int, val rateOfReturn: Double)

