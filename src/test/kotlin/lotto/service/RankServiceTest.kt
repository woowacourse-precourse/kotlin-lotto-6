package lotto.service

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankServiceTest {
	@Test
	fun `로또 당첨 확인`() {
		val input = RankService().rateRank(WINNING_NUMBER, BONUS_NUMBER, FIRST)
		val result = mutableListOf(1, 0, 0, 0, 0)
		assertThat(input).isEqualTo(result)
	}

	@Test
	fun `로또 당첨 확인 2등`() {
		val input = RankService().rateRank(WINNING_NUMBER, BONUS_NUMBER, SECOND)
		val result = mutableListOf(0, 1, 0, 0, 0)
		assertThat(input).isEqualTo(result)
	}

	companion object {
		private val WINNING_NUMBER = mutableSetOf(1, 2, 3, 4, 5, 6)
		private const val BONUS_NUMBER = 7
		private val FIRST = mutableListOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
		private val SECOND = mutableListOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
	}
}