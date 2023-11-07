package lotto

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
            InputValidator.validateWinningNumber("45, 1, 2, 3, 4, 5")
        }
    }


    // 아래에 추가 테스트 작성 가능
}
