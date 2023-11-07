package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `로또 번호에 와 당첨 번호를 옳바르게 비교하는지 확인`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        val matchCount = lotto.getMatchCount(winningNumbers)
        assertEquals(3, matchCount)
    }

    @Test
    fun `보너스 번호가 로또 번호와 같으면 예외가 발생한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 6
        assertThrows<IllegalArgumentException> {
            lotto.checkBonus(bonusNumber)
        }
    }
    @Test
    fun `번호를 문자열로 변경하는지 확인 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expectedResult = "[1, 2, 3, 4, 5, 6]"
        assertEquals(expectedResult, lotto.toString())
    }
    @Test
    fun `수익률이 올바르게 계산되어야 한다`() {
        val results = listOf(LottoResult.FIVE_MATCHES, LottoResult.THREE_MATCHES)
        val purchaseAmount = 2000
        val expectedProfitRate = ((LottoResult.FIVE_MATCHES.prize + LottoResult.THREE_MATCHES.prize).toDouble() / purchaseAmount) * 100
        val actualProfitRate = calculateProfitRate(results, purchaseAmount)
        assertEquals(expectedProfitRate, actualProfitRate)
    }
}