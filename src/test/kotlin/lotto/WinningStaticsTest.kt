package lotto

import lotto.model.Winning
import lotto.model.WinningStatics
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class WinningStaticsTest {
    @Test
    fun `모든 Winning 항목의 개수를 셀 때 예외 없이 수행한다`() {
        val statics = WinningStatics(winnings = listOf(Winning.None), profitPercentage = 0.0)
        val winnings = Winning.values()

        winnings.forEach { winning ->
            assertDoesNotThrow {
                statics.countOf(winning)
            }
        }
    }

    @Test
    fun `Winning 항목의 개수를 정확히 센다`() {
        val statics = WinningStatics(
            winnings = listOf(Winning.None, Winning.None, Winning.Five, Winning.Six),
            profitPercentage = 0.0
        )

        assert(statics.countOf(Winning.None) == 2)
        assert(statics.countOf(Winning.Five) == 1)
        assert(statics.countOf(Winning.Six) == 1)
    }
}
