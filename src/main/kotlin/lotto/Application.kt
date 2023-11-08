package lotto

fun main() {
    val price = promptLottoPrice()
    val lottoTickets = buyLottoTickets(price)
    val winningNumber = promptWinningNumber()

    val rankCounts = calculateRankCount(lottoTickets, winningNumber)
    val totalReward = calculateTotalReward(rankCounts)
    val rewardRate = rewardRateCalculate(totalReward, price)
    displayResult(rewardRate, rankCounts)
}
