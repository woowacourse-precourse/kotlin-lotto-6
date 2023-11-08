package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {
    @Test
    fun `당첨 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 모두 맞은 경우`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedCount = 6
        assertThat(expectedCount).isEqualTo(winningLotto.countMatchedNumbers(lotto))
    }

    @Test
    fun `당첨 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 하나도 맞지 않은 경우`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val expectedCount = 0
        assertThat(expectedCount).isEqualTo(winningLotto.countMatchedNumbers(lotto))
    }

    @ParameterizedTest
    @CsvSource(value = ["1 : true", "7 : false"], delimiter = ':')
    fun `보너스 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트`(bonus: Int, expected: Boolean) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), bonus)
        assertThat(winningLotto.hasBonusNumber(lotto)).isEqualTo(expected)
    }
}