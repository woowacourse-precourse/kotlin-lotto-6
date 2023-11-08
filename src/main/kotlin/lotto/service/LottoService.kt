package lotto.service

import lotto.global.Config
import lotto.global.Error

class LottoService {
	private var lottoNumber: MutableSet<Int> = mutableSetOf()
	private var bonusNumber: Int = 0

	fun winningNumber(winningNumber: String) {
		winningNumber.split(",").forEach{
			val number = try {
				it.toInt()
			} catch (e: NumberFormatException) {
				throw IllegalArgumentException(Error.NOT_NUMBER.message())
			}
			require(number in (1..Config.LOTTO_RANGE.value)) {Error.NUMBER_RANGE.message()}
			lottoNumber.add(number)
		}
		require(lottoNumber.size == 6) {Error.NUMBER_NUMBER.message()}

		lottoNumber = lottoNumber.toSortedSet()
	}

	fun bonusNumber(bonusNumber: String) {
		val number = try {
			bonusNumber.toInt()
		} catch (e: NumberFormatException) {
			throw IllegalArgumentException(Error.NOT_NUMBER.message())
		}
		require(number in (1..Config.LOTTO_RANGE.value)) {Error.NUMBER_RANGE.message()}
		this.bonusNumber = number
	}

	fun getLotto(): MutableSet<Int> {
		return lottoNumber
	}
	fun getBonus(): Int {
		return bonusNumber
	}
}