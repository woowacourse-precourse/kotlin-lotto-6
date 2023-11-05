package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    val lottoResult = LottoResult()

    @BeforeEach
    fun init() {
        lottoResult.winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    }


    @Test
    fun `구입한 로또 번호와 당첨 번호 6개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.SIX_MATCH.value)
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호 5개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.FIVE_MATCH.value)
    }
    @Test
    fun `구입한 로또 번호와 당첨 번호 4개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.FOUR_MATCH.value)
    }
    @Test
    fun `구입한 로또 번호와 당첨 번호 3개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.THREE_MATCH.value)
    }
    @Test
    fun `당첨 번호에 보너스 번호가 있는지 확인한다`() {
        lottoResult.bonus = 42
        lottoResult.winLotto = Lotto(listOf(1, 2, 3, 4, 5, 42))

        assertTrue(lottoResult.hasBonus())
    }
}