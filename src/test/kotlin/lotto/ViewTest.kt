package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ViewTest {
    val validation = Validation()

    @Test
    fun `입력값이 숫자가 아닐때`() {
        val input = "글자"
        assertThrows<IllegalArgumentException> {
            validation.checkInt(input)
        }
    }

    @Test
    fun `입력값이 1000원단위가 아닐 때`() {
        val input = "1234"
        assertThrows<IllegalArgumentException> {
            validation.checkInputPayment(input)
        }
    }

    @Test
    fun `당첨번호 입력값이 숫자 6개가 아닐 때`() {
        val input = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> {
            validation.checkInputLottoNumber(input)
        }
    }

    @Test
    fun `보너스 번호 입력값이 1 ~ 45가 아닐 때 `() {
        val input = "555"
        assertThrows<IllegalArgumentException> {
            validation.checkInputBonusNumber(input)
        }
    }
}
