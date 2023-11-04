package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
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
        val numbers = Randoms.pickUniqueNumbersInRange(
            LottoNumber.MIN_LOTTO_NUMBER,
            LottoNumber.MAX_LOTTO_NUMBER,
            Lotto.LOTTO_SIZE
        ).sorted()
        return Lotto(numbers.map { LottoNumber(it) })
    }
}