package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPurchase
import lotto.domain.WinningNumberGenerator
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
    fun `로또 구입 금액이 숫자가 아닌 경우 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase().validateAmount("abcd")
        }
    }

    @Test
    fun `로또 구입 금액이 1,000원 단위가 아닌 경우 예외 처리`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase().validateAmount("12001")
        }
    }

    @Test
    fun `로또 번호가 오른차순이 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 6, 5))
        }
    }

    @Test
    fun `당첨 번호에 중복이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winningNumber = "1,2,3,4,5,5"
            WinningNumberGenerator().validateWinningNumber(winningNumber)
        }
    }

    @Test
    fun `당첨 번호와 보너스 번호에 중복이 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            val winningNumber = "1,2,3,4,5,6"
            val bonusNumber = "6"
            WinningNumberGenerator().validateWinningNumber(winningNumber)
            WinningNumberGenerator().validateBonusNumber(bonusNumber, winningNumber.split(",").map { it.toInt() })
        }
    }
}
