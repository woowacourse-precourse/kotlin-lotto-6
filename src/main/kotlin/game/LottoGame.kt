package game

import domain.*
import model.PurchaseLottoInfo
import ui.InputManager
import ui.OutputManager

class LottoGame(
    private val inputManager: InputManager = InputManager(),
    private val outputManager: OutputManager = OutputManager(),
    private val lottoGenerator: LottoGenerator = LottoGenerator()
) {
    fun startLottoGame() {
        with(outputManager) {
            promptPurchaseAmount()
            val purchaseInfo: PurchaseLottoInfo = purchaseAmount().apply { purchaseLottoCount(this.lottoCount) }
            val publishLottoResult: List<Lotto> = publishLotto(purchaseInfo.lottoCount).apply { lottoNumbers(this) }
            promptJackpotNumbers()
            val jackpotNumbers: ArrayList<Int> = getJackpotNumbers().apply {
                promptBonusNumber()
                add(getBonusNumber(this))
            }
            lottoStats()
            val lottoResult = LottoResult(purchaseLotto = publishLottoResult, lottoPrizeCheck = LottoPrizeCheck(jackpotNumbers))
            prizeResult(lottoResult.prizeResult())
            val totalResult = LottoRateOfReturn(amount = purchaseInfo.amount, checkPrize = lottoResult.prizeResult())
            rateOfReturn(totalResult.rateOfReturn())
        }
    }

    private fun purchaseAmount() = inputManager.lottoPurchaseAmount { outputManager.invalidPurchaseAmount() }

    private fun publishLotto(lottoCount: Int): ArrayList<Lotto> {
        val publishLotto = arrayListOf<Lotto>()
        repeat(lottoCount) { publishLotto.add(Lotto(lottoGenerator.createLottoNumber())) }
        return publishLotto
    }

    private fun getJackpotNumbers(): ArrayList<Int> =
        inputManager.jackpotNumbers { outputManager.invalidLottoNumbers() }

    private fun getBonusNumber(jackpotNumbers: List<Int>): Int =
        inputManager.bonusNumber(jackpotNumbers) { outputManager.invalidBonusNumber() }
}