package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class WinningNumbersTest {
    @Test
    fun `보너스 번호가 중복이면 예외가 발생한다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 3
        assertThrows<IllegalArgumentException> {
            val winningNumbers = WinningNumbers(winningNumbers)
            winningNumbers.setBonusNumber(bonusNumber)
        }
    }

    @Test
    fun `로또의 당첨 결과를 맞춰서 순위를 반환한다`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 6))
        winningNumbers.setBonusNumber(bonusNumber)
        assertThat(winningNumbers.lottoToWinningRank(lotto)).isEqualTo(WinningRank.SECOND)
    }
}