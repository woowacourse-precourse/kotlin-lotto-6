package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

private const val MATCH_BONUS_NUMBER = 9
private const val NO_MATCH_BONUS_NUMBER = 10

class WinningLottoTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
    private val winningLotto = WinningLotto(winningNumbers)

    @Test
    fun `정답 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) })
        }
    }

    @Test
    fun `정답 로또 번호의 개수가 6개 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it) })
        }
    }

    @Test
    fun `정답 로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }
    }

    @Test
    fun `로또 번호의 개수가 6개이고 에 중복된 숫자가 없으면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        }
    }

    @Test
    fun `정답 로또의 개수가 6개이면 SIX_MATCHES를 반환한다`() {
        val playerNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, NO_MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.SIX_MATCHES))

    }

    @Test
    fun `정답 로또의 개수가 5개이고 보너스 번호를 맞췄으면 FIVE_MATCHES_WITH_BONUS_NUMBER를 반환한다`() {

        val playerNumbers = listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.FIVE_MATCHES_WITH_BONUS_NUMBER))
    }

    @Test
    fun `정답 로또의 개수가 5이고 보너스 번호를 맞추지 않았으면 FIVE_MATCHES를 반환한다`() {
        val playerNumbers = listOf(1, 2, 3, 4, 5, 9).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, NO_MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.FIVE_MATCHES))
    }

    @Test
    fun `정답 로또의 개수가 4개이면 FOUR_MATCHES를 반환한다`() {
        val playerNumbers = listOf(1, 2, 3, 4, 8, 9).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, NO_MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.FOUR_MATCHES))
    }

    @Test
    fun `정답 로또의 개수가 3이면 THREE_MATCHES를 반환한다`() {
        val playerNumbers = listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, NO_MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.THREE_MATCHES))
    }

    @Test
    fun `정답 로또의 개수가 2개 이하면 NO_MATCHES를 반환한다`() {
        val playerNumbers = listOf(1, 2, 7, 8, 9, 10).map { LottoNumber(it) }
        val playerLotto = Lotto(playerNumbers)

        val rank = winningLotto.determineWinner(playerLotto, NO_MATCH_BONUS_NUMBER)
        assertThat(rank.equals(WinningRank.NO_MATCHES))
    }
}