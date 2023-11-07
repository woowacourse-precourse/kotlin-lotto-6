package lotto.service

import lotto.constant.LottoConstant
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.util.FormatUtil
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoServiceTest {

    @Test
    fun `구매 금액에 따라 올바른 로또 수 계산`() {
        val purchaseAmount = 5000
        val expectedLottoCount = purchaseAmount / LottoConstant.LOTTO_PRICE
        assertEquals(expectedLottoCount, LottoService.calculateLottoCount(purchaseAmount))
    }

    @Test
    fun `로또 생성 시 6개의 고유 번호가 1부터 45 사이에 있어야 함`() {
        val lottoCount = 5
        val lottos = LottoService.generateLottos(lottoCount)

        assertEquals(lottoCount, lottos.size)
        lottos.forEach { lotto ->
            assertEquals(LottoConstant.LOTTO_SIZE, lotto.getNumbers().size)
            assertTrue(lotto.getNumbers().all { it in LottoConstant.LOTTO_MIN..LottoConstant.LOTTO_MAX })
            assertEquals(LottoConstant.LOTTO_SIZE, lotto.getNumbers().distinct().size)
        }
    }

    @Test
    fun `로또 당첨 결과 계산`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(10, 20, 30, 40, 41, 42)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(2, 3, 6, 7, 10, 11))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = LottoService.calculateResult(lottos, winningNumbers, bonusNumber)

        assertTrue(result.containsKey(Rank.FIRST))
        assertTrue(result[Rank.FIRST] == 1)
        assertTrue(result[Rank.SECOND] == 1)
        assertNull(result[Rank.THIRD])
        assertNull(result[Rank.FOURTH])
        assertTrue(result[Rank.FIFTH] == 1)
    }

    @Test
    fun `로또 수익률 계산`() {
        val result = mapOf(
            Rank.FIRST to 1,
            Rank.THIRD to 2,
        )
        val purchaseAmount = 3000
        val earningRate = LottoService.calculateEarningRate(result, purchaseAmount)
        val expectedEarningRate = ((2000000000 + 1500000 * 2) / 3000.0) * 100
        assertEquals(FormatUtil.formatEarningRate(expectedEarningRate), earningRate)
    }
}
