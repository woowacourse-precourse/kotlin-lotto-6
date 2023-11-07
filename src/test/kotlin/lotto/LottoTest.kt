package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `일치하는 번호의 개수와 보너스 번호 여부에 따른 결과를 올바르게 반환해야 한다`() {
        val resultWithBonus = LottoResult.fromMatchCount(5, true)
        val resultWithoutBonus = LottoResult.fromMatchCount(5, false)
        assertThat(resultWithBonus).isEqualTo(LottoResult.FIVE_MATCHES_AND_BONUS)
        assertThat(resultWithoutBonus).isEqualTo(LottoResult.FIVE_MATCHES)
    }

    @Test
    fun `상금을 올바르게 계산해야 한다`() {
        val result = LottoResult.FIVE_MATCHES
        val expectedPrize = 1500000
        assertThat(result.prize).isEqualTo(expectedPrize)
    }

    @Test
    fun `generateLottoNumbers 함수가 항상 범위 내의 유일한 숫자 6개를 반환하는지 확인한다`() {
        val numbers = generateLottoNumbers()
        assertThat(numbers).hasSize(6)
        assertThat(numbers.distinct()).hasSize(6)
        assertThat(numbers.all { it in 1..45 }).isTrue()
    }

    @Test
    fun `getResults 함수가 정확한 당첨 결과를 반환하는지 확인한다`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        val bonusNumber = 10
        val results = getResults(tickets, winningNumbers, bonusNumber)
        assertThat(results).containsExactly(LottoResult.THREE_MATCHES)
    }

    @Test
    fun `로또 번호에 1~45 범위를 벗어난 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46))
        }
    }
}