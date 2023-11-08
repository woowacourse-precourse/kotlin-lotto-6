package lotto.service

import lotto.global.Error
import lotto.model.Issuer

class IssuerService {
	private var lottos: MutableList<MutableSet<Int>> = mutableListOf()

	fun purchaseLotto(amount: String): Int {
		require(amount.matches(Regex("^[0-9]*[1-9]000$"))) {Error.PURCHASE_AMOUNT.message()}
		return amount.substring(0, amount.length-3).toInt()
	}

	fun createLotto(count: Int): MutableList<MutableSet<Int>> {
		for(i in 0 until count) {
			lottos.add(Issuer().numbers)
		}
		return lottos
	}

	fun getLotto(): MutableList<MutableSet<Int>> {
		return lottos
	}
}