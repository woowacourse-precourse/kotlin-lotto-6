package lotto.model

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoStaticsTest {
    @Test
    fun `당첨 통계 테스트`() {

        assertRandomUniqueNumbersInRangeTest(
            {
                val lottoManager = LottoManager(PURCHASE_AMOUNT)
                lottoManager.create()
                val lottoStatics = LottoStatics(lottoManager)
                val winStatics = lottoStatics.getWinStatics(ANSWER, BONUS)
                assertEquals(winStatics[WinningType.FOURTH], 1)
                assertEquals(winStatics[WinningType.FIFTH], 1)
            },
            listOf(1, 2, 3, 4, 7, 8),
            listOf(4, 5, 6, 18, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
        )
    }

    @Test
    fun `총 수익률 계산 테스트`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val lottoManager = LottoManager(PURCHASE_AMOUNT)
                lottoManager.create()
                val lottoStatics = LottoStatics(lottoManager)
                lottoStatics.getWinStatics(ANSWER, BONUS)
                val returnRate = lottoStatics.getReturnRate(PURCHASE_AMOUNT)
                assertEquals(returnRate, "1100.0")
            },
            listOf(1, 2, 3, 4, 7, 8),
            listOf(4, 5, 6, 18, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42),
            listOf(13, 14, 16, 38, 42, 45),
        )
    }

    companion object {
        private val ANSWER = listOf(1, 2, 3, 4, 5, 6)
        private const val BONUS = 7
        private const val PURCHASE_AMOUNT = 5000
    }

}