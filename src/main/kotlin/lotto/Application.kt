package lotto

fun main() {
    val cost = LottoPurchase().purchaseCheck()
    val lottoNumbers = LottoGenerater().randomLotto(cost/1000)
    val prizeNumber = LottoPick().pickNumber()
    val bonusNumber = LottoBonus().bonusPickNumber(prizeNumber)
    val totalProfit = Lotto(prizeNumber).compareLotto(lottoNumbers, bonusNumber)
    Lotto(prizeNumber).lottoProfit(cost, totalProfit)
}
