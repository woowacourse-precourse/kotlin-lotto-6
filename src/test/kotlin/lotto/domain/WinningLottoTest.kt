package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinningLottoTest {
    private lateinit var winningLotto: WinningLotto

    @BeforeEach
    fun setUp() {
        winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
    }

    @Test
    fun `당첨 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 모두 맞은 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = 6
        assertThat(expected).isEqualTo(winningLotto.checkCountMatched(lotto))
    }

    @Test
    fun `당첨 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 하나도 맞지 않은 경우`() {
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val expected = 0
        assertThat(expected).isEqualTo(winningLotto.checkCountMatched(lotto))
    }

    @Test
    fun `보너스 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 맞은 경우`() {
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val expected = true
        assertThat(expected).isEqualTo(winningLotto.checkBonusMatch(lotto))
    }

    @Test
    fun `보너스 번호와 로또 번호를 비교하여 맞은 개수를 확인하는 기능 테스트 - 맞지 않은 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = false
        assertThat(expected).isEqualTo(winningLotto.checkBonusMatch(lotto))
    }
}