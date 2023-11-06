package lotto

import domain.Lotto
import domain.LottoPrizeCheck
import domain.LottoResult
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoResultTest {
    @Test
    fun `전체 로또 당첨 결과를 확인`() {
        val lottoPrizeCheck = LottoPrizeCheck(JACKPOT_NUMBERS)
        val lottoResult = LottoResult(
            purchaseLotto = LOTTO_NUMBERS,
            lottoPrizeCheck = lottoPrizeCheck
        )
        val prizeResult = lottoResult.prizeResult()
        assertEquals(listOf(1, 1, 0, 0, 0), prizeResult.toList())
    }

    @Test
    fun `일치하는 번호가 5개인 경우 일반 번호와 보너스 번호 확인`() {
        val lottoPrizeCheck = LottoPrizeCheck(JACKPOT_NUMBERS)
        val lottoResult = LottoResult(
            purchaseLotto = LOTTO_NUMBERS_OF_SECOND_PLACE,
            lottoPrizeCheck = lottoPrizeCheck
        )
        val prizeResult = lottoResult.prizeResult()
        assertEquals(listOf(0, 0, 1, 1, 0), prizeResult.toList())
    }

    companion object {
        private val JACKPOT_NUMBERS = listOf(1, 2, 3, 4, 7, 9, 44)
        private val LOTTO_NUMBERS = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(1, 2, 3, 31, 41, 42)),
            Lotto(listOf(1, 2, 3, 4, 41, 42)),
        )
        private val LOTTO_NUMBERS_OF_SECOND_PLACE = listOf(
            Lotto(listOf(1, 2, 3, 4, 40, 44)),
            Lotto(listOf(1, 2, 3, 4, 7, 21)),
        )
    }
}