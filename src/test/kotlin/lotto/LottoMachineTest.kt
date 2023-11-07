package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private val lotto = mutableListOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        Lotto(listOf(1, 2, 4, 8, 16, 32)),
        Lotto(listOf(3, 6, 9, 12, 15, 18)),
        Lotto(listOf(4, 8, 16, 32, 38, 45)),
    )
    private val inputLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    private val bonusNumber = BonusNumber("8", inputLotto)

    @Test
    fun `당첨 내역 결과`() {
        val prize = LottoMachine().winningLotteryResult(lotto, inputLotto, bonusNumber)
        val result = Prize(first = 1, fifth = 1, miss = 2)
        assertThat(prize).isEqualTo(result)
    }
}