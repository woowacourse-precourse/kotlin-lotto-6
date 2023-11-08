package lotto.service

import lotto.global.Prize
import lotto.model.Lotto
import kotlin.math.round

class RankService {
	fun rateRank(
		winningNumber: MutableSet<Int>,
		bonusNumber: Int,
		lottos: MutableList<Lotto>
	): MutableList<Int> {
		val matches: MutableList<Int> = mutableListOf(0, 0, 0, 0, 0)

		lottos.forEach { it: Lotto ->
			when (checkSameNumber(it.getLotto(), winningNumber)) {
				3 -> matches[4]++
				4 -> matches[3]++
				5 -> if (!it.getLotto().contains(bonusNumber)) {
					matches[2]++
				} else {
					matches[1]++
				}

				6 -> matches[0]++
			}
		}
		return matches
	}

	fun checkSameNumber(numbers: List<Int>, winningNumber: MutableSet<Int>): Int {
		var matchCount = 0
		for (number in numbers) {
			if (winningNumber.contains(number)) {
				matchCount++
			}
		}
		return matchCount
	}

	fun calculateReturn(price: Int, matches: MutableList<Int>): Double {
		var totalPrize = 0
		for (i in 1..5) totalPrize += Prize.from(i).calculation(matches[i - 1])
		val d = totalPrize.toDouble() / price.toDouble() * 100
		return round(d * 100) / 100
	}
}