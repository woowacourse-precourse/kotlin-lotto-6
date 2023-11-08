package lotto

class LottoManager {
    fun lottoControl() {
        val cost = LottoPurchase().purchaseCheck()
        val lottoNumbers = LottoGenerator().randomLotto(cost/1000)
        val prizeNumber = LottoPick().pickNumber()
        val bonusNumber = LottoBonus().bonusPickNumber(prizeNumber)
        val totalProfit = Lotto(prizeNumber).compareLotto(lottoNumbers, bonusNumber)
        Lotto(prizeNumber).lottoProfit(cost, totalProfit)
    }
}