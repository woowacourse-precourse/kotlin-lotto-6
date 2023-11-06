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
            val purchaseInfo: PurchaseLottoInfo = getPurchaseAmount().apply { purchaseLottoCount(this.lottoCount) }
            val purchaseLotto: List<Lotto> = getPurchaseLottoResult(purchaseInfo.lottoCount).apply { lottoNumbers(this) }
            promptJackpotNumbers()
            val jackpotNumbers: ArrayList<Int> = getJackpotNumbers().apply {
                promptBonusNumber()
                add(getBonusNumber(this))
            }
            lottoStats()
            val lottoResult = LottoResult(purchaseLotto = purchaseLotto, lottoPrizeCheck = LottoPrizeCheck(jackpotNumbers))
            prizeResult(lottoResult.prizeResult())
            val totalResult = LottoRateOfReturn(amount = purchaseInfo.amount, checkPrize = lottoResult.prizeResult())
            rateOfReturn(totalResult.rateOfReturn())
        }
    }

    private fun getPurchaseAmount() = inputManager.lottoPurchaseAmount { outputManager.invalidPurchaseAmount() }

    private fun getPurchaseLottoResult(lottoCount: Int): ArrayList<Lotto> {
        val purchaseLotto = arrayListOf<Lotto>()
        repeat(lottoCount) { purchaseLotto.add(Lotto(lottoGenerator.createLottoNumber())) }
        return purchaseLotto
    }

    private fun getJackpotNumbers(): ArrayList<Int> =
        inputManager.jackpotNumbers { outputManager.invalidLottoNumbers() }

    private fun getBonusNumber(jackpotNumbers: List<Int>): Int =
        inputManager.bonusNumber(jackpotNumbers) { outputManager.invalidBonusNumber() }
}