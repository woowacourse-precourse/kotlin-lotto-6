package lotto.view

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    private val input = Input()
    @Test
    fun `validatePurchaseAmount 메서드 사용시 1000원으로 나누어 떨어지지 않을 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validatePurchaseAmount("14900")
        }
    }

    @Test
    fun `validatePurchaseAmount 메서드 사용시 문자일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validatePurchaseAmount("asdf")
        }
    }

    @Test
    fun `validatePurchaseAmount 메서드 사용시 공백일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validatePurchaseAmount("")
        }
    }
    @Test
    fun `validateWinningLottoNumber 메서드 사용시 문자일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validateWinningLottoNumber("asdf")
        }
    }
    @Test
    fun `validateWinningLottoNumber 메서드 사용시 공백일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validateWinningLottoNumber("")
        }
    }

    @Test
    fun `validateWinningLottoNumber 메서드 사용시 숫자가 6개가 아닐 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validateWinningLottoNumber("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `validateBonusNumber 메서드 사용시 문자일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validateBonusNumber("asdf")
        }
    }

    @Test
    fun `validateBonusNumber 메서드 사용시 공백일 때 오류 발생`() {
        //then
        assertThrows<IllegalArgumentException> {
            input.validateBonusNumber("")
        }
    }
}