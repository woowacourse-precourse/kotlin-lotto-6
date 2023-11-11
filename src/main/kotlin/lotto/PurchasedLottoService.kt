package lotto

import lotto.dto.CostDto
import lotto.dto.PurchasedLottoDto
import lotto.model.PurchasedLotto
import lotto.utility.Utils

class PurchasedLottoService(lottoCount: Int) {
    val purchasedLottoCollection = mutableListOf<PurchasedLotto>()

    init {
        for (i in 0..<lottoCount) {
            purchasedLottoCollection.add(PurchasedLotto())
        }
    }

    fun setPurchsedLottoCollection(lottoList: List<Int>, bonusBall: Int) {
        for (purchasedLotto in purchasedLottoCollection)
            purchasedLotto.setPurchasedLotto(lottoList, bonusBall)
    }

    fun sumAllPrize(): Int {
        var sum = 0

        for (lotto in purchasedLottoCollection) {
            sum += lotto.getWinPrize()
        }
        return sum
    }

    fun calculateRateOfReturn(cost: CostDto): Double {
        val sum = sumAllPrize()

        return Utils.roundToOneDeimalPlace(sum.toDouble() / cost.getCost().toDouble() * 100)
    }

    fun getWinStatics(): MutableList<Int> {
        val winStatics = mutableListOf(0, 0, 0, 0, 0, 0)

        for (purchasedLotto in purchasedLottoCollection) {
            winStatics[purchasedLotto.getWinRank()] += 1
        }

        return winStatics
    }

    fun getPurchasedLottoDtoList(): MutableList<PurchasedLottoDto> {
        val lottoList = mutableListOf<PurchasedLottoDto>()

        for (lotto in purchasedLottoCollection) {
            lottoList.add(PurchasedLottoDto(lotto.getNumbers(), lotto.getWinPrize(), lotto.getWinRank()))
        }
        return lottoList
    }
}