package lotto.domain

import lotto.exception.LottoShopException

object LottoShop {

    private val LOTTO_PRICE = Money(1000)

    fun buyLottos(money: Money): Lottos {
        checkHasEnoughMoney(money)
        checkDivisibleByLottoPrice(money)
        val quantity = money.amount / LOTTO_PRICE.amount
        val lottos = (1..quantity).map { generateLotto() }
        return Lottos(lottos)
    }

    private fun checkDivisibleByLottoPrice(money: Money) =
        require(money.amount % LOTTO_PRICE.amount == 0) {
            LottoShopException.NOT_DIVISIBLE_WITH_LOTTO_PRICE.getLottoPrice(LOTTO_PRICE.amount)
        }

    private fun checkHasEnoughMoney(money: Money) =
        require(money.amount >= LOTTO_PRICE.amount) {
            LottoShopException.NOT_ENOUGH_MONEY.getLottoPrice(LOTTO_PRICE.amount)
        }

    private fun generateLotto(): Lotto {
        val numbers = (1..45).shuffled().take(6).sorted()
        return Lotto(numbers.map { LottoNumber(it) })
    }
}