package lotto

import lotto.user.LottoPick
import lotto.user.LottoPurchase
import lotto.user.LottoBonusPick
import lotto.model.Lotto
import lotto.model.LottoCalculate
import lotto.util.LottoGenerator

class LottoManager {
    fun lottoControl() {
        val cost = LottoPurchase().purchaseCheck()
        val lottoNumbers = LottoGenerator().randomLotto(cost/1000)
        val prizeNumber = LottoPick().pickNumber()
        val bonusNumber = LottoBonusPick().bonusPickNumber(prizeNumber)
        val totalProfit = Lotto(prizeNumber).compareLotto(lottoNumbers, bonusNumber)
        LottoCalculate().lottoProfit(cost, totalProfit)
    }
}