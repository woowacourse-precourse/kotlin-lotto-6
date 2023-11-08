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
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = Bonus(7)
        winningRecord.updateWinningResults(purchasedLottos, winningLotto, bonus)
        val expectedWinningAmount = WinningRank.FIRST.amount

        val actualWinningAmount = profitRate.sumTotalWinningAmount(winningRecord)

        assertThat(actualWinningAmount).isEqualTo(expectedWinningAmount)
    }
}