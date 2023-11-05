package game

import domain.*
import model.PurchaseLottoInfo
import model.Winning
import ui.InputManager
import ui.OutputManager

class LottoGame(
    private val inputManager: InputManager = InputManager(),
    private val outputManager: OutputManager = OutputManager(),
    private val lottoGenerator: LottoGenerator = LottoGenerator()
) {
    fun startLottoGame() {
        outputManager.promptPurchaseAmount()
        val purchaseInfo: PurchaseLottoInfo = getPurchaseAmount().apply { outputManager.purchaseLottoCount(this.lottoCount) }

        val purchaseLotto: List<Lotto> = getPurchaseLottoResult(purchaseInfo.lottoCount)
        outputManager.lottoNumbers(purchaseLotto)

        outputManager.promptJackpotNumbers()
        val jackpotNumbers: ArrayList<Int> = getJackpotNumbers().apply {
            outputManager.promptBonusNumber()
            add(getBonusNumber(this))
        }

        val lottoPrize = LottoPrizeCheck(jackpotNumbers = jackpotNumbers)
        val lottoResult = LottoResult(purchaseLotto = purchaseLotto, lottoPrizeCheck = lottoPrize).lottoResult()
        val totalResult = LottoRateOfReturn(amount = purchaseInfo.amount, checkPrize = lottoResult)
        test(totalResult)
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

    private fun test(totalResult: LottoRateOfReturn) {
        Winning.values().forEachIndexed { index, winning ->
            println("$winning ${totalResult.checkPrize[index]}개")
        }
        println(totalResult.rateOfReturn())
    }
}