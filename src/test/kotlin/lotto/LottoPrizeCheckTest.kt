package lotto

import domain.Lotto
import domain.LottoPrizeCheck
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoPrizeCheckTest {
    @Test
    fun `로또 당첨순위를 확인`() {
        val lotto = Lotto(LOTTO_NUMBERS)
        assertEquals(LottoPrizeCheck(JACKPOT_NUMBERS).checkPrize(lotto), FOURTH_PLACE_INDEX)
    }

    companion object {
        private val JACKPOT_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
        private val LOTTO_NUMBERS = listOf(3, 4, 5, 21, 22, 23)
        private const val BONUS_NUMBER = 7
        private const val FOURTH_PLACE_INDEX = 0
    }
}