package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.global.Config
import lotto.global.Error
import lotto.model.Lotto

class LottoService {
	private var price = Config.LOTTO_PRICE
	private var lottos: MutableList<Lotto> = mutableListOf()

	fun purchaseLotto(price: String): Int {
		require(price.matches(Regex("^[0-9]*$"))) { Error.NOT_NUMBER.message() }
		require(
			(price.toDouble() / Config.LOTTO_PRICE).toString().matches(Regex("^[0-9]+.0$"))
		) { Error.PURCHASE_AMOUNT.message() }
		this.price = price.toInt()
		return this.price / Config.LOTTO_PRICE
	}

	fun createLotto(count: Int) {
		for (i in 0..<count) {
			val random = makeRandomNumber()
			println(random)
			lottos.add(Lotto(random))
		}
	}

	private fun makeRandomNumber(): MutableList<Int> {
		return Randoms.pickUniqueNumbersInRange(1, Config.LOTTO_RANGE, Config.NUMBER_DRAW)
	}

	fun getPrice(): Int {
		return price
	}

	fun getLotto(): MutableList<Lotto> {
		return lottos
	}
}