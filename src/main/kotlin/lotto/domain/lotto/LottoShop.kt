package lotto.domain.lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.*
import lotto.domain.winningResult.MatchCount
import lotto.domain.winningResult.RateOfReturn
import lotto.domain.winningResult.WinningRank
import lotto.domain.winningResult.WinningResult
import lotto.exception.LottoShopException

object LottoShop {

    private val LOTTO_PRICE = Money(1000)

    fun purchaseLottos(money: Money): Lottos {
        checkHasEnoughMoney(money)
        checkDivisibleByLottoPrice(money)
        val quantity = money.amount / LOTTO_PRICE.amount
        val lottos = (1..quantity).map { generateLotto() }
        return Lottos(lottos)
    }

    fun getWinningResult(winningLotto: WinningLotto, purchasedLottos: Lottos): WinningResult {
        val result = mutableMapOf<WinningRank, MatchCount>()
        WinningRank.entries.forEach { result[it] = MatchCount(0) }

        purchasedLottos.forEach {
            val numberMatchCount = it.getLottoMatchCount(winningLotto.winningNumbers)
            val isBonusNumberMatched = it.isContainLottoNumber(winningLotto.bonusNumber)
            val rank = WinningRank.getRank(numberMatchCount, isBonusNumberMatched)
            result[rank]!!.count++
        }

        val totalRevenue = result.entries.sumOf { it.key.prize.amount * it.value.count.toDouble() }
        val totalPurchasePrice = purchasedLottos.size() * LOTTO_PRICE.amount.toDouble()
        val rateOfReturn = RateOfReturn(totalRevenue / totalPurchasePrice * 100)
        return WinningResult(result, rateOfReturn)
    }

    private fun checkDivisibleByLottoPrice(money: Money) =
        require(money.amount % LOTTO_PRICE.amount == 0) {
            LottoShopException.NOT_DIVISIBLE_WITH_LOTTO_PRICE.getLottoPrice(LOTTO_PRICE)
        }

    private fun checkHasEnoughMoney(money: Money) =
        require(money.amount >= LOTTO_PRICE.amount) {
            LottoShopException.NOT_ENOUGH_MONEY.getLottoPrice(LOTTO_PRICE)
        }

    private fun generateLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoNumber.MIN_LOTTO_NUMBER,
            LottoNumber.MAX_LOTTO_NUMBER,
            Lotto.LOTTO_SIZE
        ).sorted()
        return Lotto(numbers.map { LottoNumber(it) })
    }
}