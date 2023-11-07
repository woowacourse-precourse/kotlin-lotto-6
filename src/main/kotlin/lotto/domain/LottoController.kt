package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.LottoRank
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    val lottoResult = makeLottoResultMap()
    fun start() {
        val money = enterPurchaseMoney()
        val lotteries = purchaseLotteries(money)
        val (prizeLottoNumber, bonusNumber) = userInputPrizeNumber()
        val sortedLottoResult = countLottoMatch(lotteries, prizeLottoNumber, bonusNumber)
        showLottoResult(money, sortedLottoResult)
    }

    fun makeLottoResultMap(): MutableMap<LottoRank, Int> {
        val lottoResult = mutableMapOf<LottoRank, Int>()
        for (i in LottoRank.entries) {
            lottoResult[i] = 0
        }
        return lottoResult
    }

    fun enterPurchaseMoney(): Int {
        outputView.printEnterPurchaseAmount()
        return inputView.inputPurchaseAmount()
    }

    fun purchaseLotteries(money: Int): MutableList<Lotto> {
        val lotteries = mutableListOf<Lotto>()
        val numOfLotto = money / LOTTO_PRICE
        outputView.printPurchaseAmount(numOfLotto)

        for (i in 0 until numOfLotto) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_NUMBER)
            outputView.printPurchasedLotto(numbers)
            lotteries.add(Lotto(numbers))
        }
        return lotteries
    }

    fun userInputPrizeNumber(): Pair<List<Int>, Int> {
        outputView.printEnterPrizeLottoNumber()
        val prizeLottoNumber = inputView.inputPrizeLottoNumber()
        outputView.printEnterPrizeBonusNumber()
        val bonusNumber = inputView.inputPrizeBonusNumber()
        return Pair(prizeLottoNumber, bonusNumber)
    }

    fun countLottoMatch(
        lotteries: List<Lotto>,
        prizeLottoNumber: List<Int>,
        bonusNumber: Int
    ): List<MutableMap.MutableEntry<LottoRank, Int>> {
        for (lotto in lotteries) {
            val (lottoNumberCount, bonusNumberMatchStatus) = lotto.matchCount(prizeLottoNumber, bonusNumber)
            val rank = LottoRank.matchRank(lottoNumberCount, bonusNumberMatchStatus)
            lottoResult[rank] = lottoResult.getOrDefault(rank, 0) + 1
        }
        lottoResult.remove(LottoRank.MISS)
        return lottoResult.entries.sortedBy { it.key.numberMatch }
    }

    fun calculateProfit(money: Int, prize: Int): Float {
        return (prize.toFloat() / money) * 100
    }

    fun showLottoResult(money: Int, sortedLottoResult: List<MutableMap.MutableEntry<LottoRank, Int>>) {
        var sumOfPrize = 0
        for (result in sortedLottoResult) {
            val key = result.key
            val value = result.value
            outputView.printResult(key.numberMatch, key.prize, key.bonusNumber, value)
            sumOfPrize += key.prize * value
        }
        outputView.printProfit(calculateProfit(money, sumOfPrize))
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val PICK_NUMBER = 6

    }
}