package lotto

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

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호에 올바르지 않은 범위의 숫자가 있으면 예외가 발생한다(45초과)`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 46, 5))
        }
    }

    @Test
    fun `로또 번호에 올바르지 않은 범위의 숫자가 있으면 예외가 발생한다(1미만)`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 45, 5))
        }
    }

    @Test
    fun `구입 금액에 숫자 이외의 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("12asd")
        }
    }
    @Test
    fun `구입 금액에 0보다 작은 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("-1")
        }
    }
    @Test
    fun `당첨 번호에 올바르지 숫자 외의 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumber("ㅁㄴㅇ, 1, 2, 3, 4, 5")
        }
    }
    @Test
    fun `당첨 번호에 올바르지 않은 범위의 숫자가 있으면 예외가 발생한다(1미만)`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumber("0, 1, 2, 3, 4, 5")
        }
    }
    @Test
    fun `당첨 번호에 올바르지 않은 범위의 숫자가 있으면 예외가 발생한다(45이상)`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumber("46, 1, 2, 3, 4, 5")
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호에 중복되는 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("1", listOf(1, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `등수 산정 테스트_1`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 7, 8, 9, 10, 11)),
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val rankCounts = lottoResult.getRankCountsForTest()

        assertEquals(1, rankCounts[1])
        assertEquals(1, rankCounts[2])
        assertEquals(1, rankCounts[3])
        assertEquals(1, rankCounts[4])
        assertEquals(1, rankCounts[5])
    }

    @Test
    fun `등수 산정 테스트_2`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 8, 5, 6))
        )
        val winningNumbers = listOf(1, 2, 3, 8, 9, 10)
        val bonusNumber = 7

        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
        val rankCounts = lottoResult.getRankCountsForTest()

        assertEquals(0, rankCounts[1])
        assertEquals(0, rankCounts[2])
        assertEquals(0, rankCounts[3])
        assertEquals(1, rankCounts[4])
        assertEquals(1, rankCounts[5])
    }

    @Test
    fun `오버플로우 테스트`() {

    }

}
