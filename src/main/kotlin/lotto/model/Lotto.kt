package lotto.model

import lotto.global.Config

class Lotto(private val numbers: List<Int>) {
	init {
		require(numbers.size == Config.NUMBER_DRAW)
		require(numbers.toSet().size == Config.NUMBER_DRAW)
		numbers.forEach { require(it in 1..Config.LOTTO_RANGE) }
	}

	fun getLotto() = numbers
}