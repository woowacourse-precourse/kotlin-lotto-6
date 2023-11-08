package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.utils.Constants
import lotto.utils.LottoRank
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    fun start() {
        val money = enterPurchaseMoney()
        val lotteries = purchaseLotteries(money)
        val (prizeLottoNumber, bonusNumber) = userInputPrizeNumber()
        val lottoResult = countLottoMatch(lotteries, prizeLottoNumber, bonusNumber)
        val sortedLottoResult = sortLottoResult(lottoResult)
        showLottoResult(money, sortedLottoResult)
    }

    fun makeLottoResultMap(): MutableMap<LottoRank, Int> {
        val lottoResult = mutableMapOf<LottoRank, Int>()
        for (rank in LottoRank.entries) {
            lottoResult[rank] = 0
        }
        return lottoResult
    }

    fun enterPurchaseMoney(): Int {
        outputView.printEnterPurchaseAmount()
        return inputView.inputPurchaseAmount()
    }

    fun purchaseLotteries(money: Int): MutableList<Lotto> {
        val lotteries = mutableListOf<Lotto>()
        val numOfLotto = money / Constants.LOTTO_PRICE
        outputView.printPurchaseAmount(numOfLotto)
        pickLottoNumberAdd(numOfLotto, lotteries)
        return lotteries
    }

    fun pickLottoNumberAdd(numOfLotto: Int, lotteries: MutableList<Lotto>) {
        for (attempts in 0 until numOfLotto) {
            val numbers = Randoms.pickUniqueNumbersInRange(
                Constants.MIN_NUMBER,
                Constants.MAX_NUMBER,
                Constants.LOTTO_NUMBER_SIZE
            )
            outputView.printPurchasedLotto(numbers)
            lotteries.add(Lotto(numbers))
        }
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
    ): MutableMap<LottoRank, Int> {
        val lottoResult = makeLottoResultMap()
        for (lotto in lotteries) {
            val (lottoNumberCount, bonusNumberMatchStatus) = lotto.matchCount(prizeLottoNumber, bonusNumber)
            val rank = LottoRank.matchRank(lottoNumberCount, bonusNumberMatchStatus)
            lottoResult[rank] = lottoResult.getOrDefault(rank, 0) + 1
        }
        lottoResult.remove(LottoRank.MISS)
        return lottoResult
    }

    fun sortLottoResult(lottoResult: MutableMap<LottoRank, Int>): MutableMap<LottoRank, Int> {
        return lottoResult.toList().sortedBy { it.first.numberMatch }.toMap().toMutableMap()
    }

    fun calculateProfit(money: Int, prize: Int): Float {
        return (prize.toFloat() / money) * 100
    }

    fun showLottoResult(money: Int, sortedLottoResult: MutableMap<LottoRank, Int>) {
        var sumOfPrize = 0
        outputView.printResultComment()
        for (result in sortedLottoResult) {
            val key = result.key
            val value = result.value
            outputView.printResult(key.numberMatch, key.prize, key.bonusNumber, value)
            sumOfPrize += key.prize * value
        }
        outputView.printProfit(calculateProfit(money, sumOfPrize))
    }
}