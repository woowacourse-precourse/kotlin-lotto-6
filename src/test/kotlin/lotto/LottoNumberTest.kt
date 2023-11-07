package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    private val validator = Validator()

    @Test
    fun `당첨 번호 입력이 없는 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoNumberInput("")
        }
    }

    @Test
    fun `입력 받은 당첨 번호가 정수가 아닌 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoNumber("1,2,3,a,4,5")
        }
    }

    @Test
    fun `입력 받은 당첨 번호가 6개가 아닌 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoSize(listOf("1,2,3,4,5"))
        }
    }

    @Test
    fun `입력 받은 당첨 번호가 1에서 45를 벗어난 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoRange(listOf("1,2,3,4,54,56"))
        }
    }

    @Test
    fun `입력 받은 당첨 번호 중 중복이 있는 경우, 오류가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            validator.validateLottoRepeat(listOf(1, 2, 2, 3, 4, 5))
        }
    }
}