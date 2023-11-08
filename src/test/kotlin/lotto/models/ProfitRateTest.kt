package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProfitRateTest {
    private lateinit var profitRate: ProfitRate
    private lateinit var winningRecord: WinningRecord


    @BeforeEach
    fun setUp() {
        profitRate = ProfitRate()
        winningRecord = WinningRecord()
    }

    @Test
    fun `당첨 내역을 통해 총 당첨 금액을 계산한다`() {
        val purchasedLottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 7))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = Bonus(7)
        winningRecord.updateWinningResults(purchasedLottos, winningLotto, bonus)
        val expectedWinningAmount = WinningRank.SECOND.amount

        val actualWinningAmount = profitRate.sumTotalWinningAmount(winningRecord)

        assertThat(actualWinningAmount).isEqualTo(expectedWinningAmount)
    }

    @Test
    fun `구매 금액과 총 당첨 금액을 통해 수익률을 계산한다`() {
        val purchaseAmount = Purchase(8000)
        val purchasedLottos = listOf(
            Lotto(listOf(8, 21, 23, 41, 42, 43)),
            Lotto(listOf(3, 5, 11, 16, 32, 38)),
            Lotto(listOf(7, 11, 16, 35, 36, 44)),
            Lotto(listOf(1, 8, 11, 31, 41, 42)),
            Lotto(listOf(13, 14, 16, 38, 42, 45)),
            Lotto(listOf(7, 11, 30, 40, 42, 43)),
            Lotto(listOf(2, 13, 22, 32, 38, 45)),
            Lotto(listOf(1, 3, 5, 14, 22, 45))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = Bonus(7)
        winningRecord.updateWinningResults(purchasedLottos, winningLotto, bonus)
        val expectedProfitRate = 62.5

        profitRate.calculate(purchaseAmount, winningRecord)
        val actualProfitRate = profitRate.value

        assertThat(actualProfitRate).isEqualTo(expectedProfitRate)
    }
}