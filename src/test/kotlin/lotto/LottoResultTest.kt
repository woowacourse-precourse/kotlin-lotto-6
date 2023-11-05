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

        assertThat(count).isEqualTo(LottoResult.MatchNumber.SIX_MATCH.count)
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호 5개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.FIVE_MATCH.count)
    }
    @Test
    fun `구입한 로또 번호와 당첨 번호 4개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.FOUR_MATCH.count)
    }
    @Test
    fun `구입한 로또 번호와 당첨 번호 3개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.THREE_MATCH.count)
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호 2개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.TWO_MATCH.count)
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호 1개가 일치하는 경우`() {
        val lotto = Lotto(listOf(1, 7, 8, 9, 10, 11))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.ONE_MATCH.count)
    }

    @Test
    fun `구입한 로또 번호와 당첨 번호가 하나도 일치하지 않는 경우`() {
        val lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val count = lottoResult.countWinNumbers(lotto)

        assertThat(count).isEqualTo(LottoResult.MatchNumber.NO_MATCH.count)
    }

    @Test
    fun `당첨 번호에 보너스 번호가 있는지 확인한다`() {
        lottoResult.bonus = 42
        lottoResult.winLotto = Lotto(listOf(1, 2, 3, 4, 5, 42))

        assertTrue(lottoResult.hasBonus())
    }
}