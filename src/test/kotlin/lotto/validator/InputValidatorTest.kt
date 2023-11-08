package lotto.validator


import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.START_INCLUSIVE
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `공백 or 아무 것도 입력하지 않았을 때`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().checkBlank(" ")
        }

        assertEquals("[ERROR] 공백을 제외한 값을 입력해 주세요", exception.message)
    }

    @Test
    fun `양의 정수가 아닐 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().checkForPositiveInteger("-1")
        }

        assertEquals("[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요", exception.message)
    }

    @Test
    fun `범위 밖의 수 입력 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator().checkForNumberRange("0")
        }

        assertEquals("[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다", exception.message)
    }

    @Test
    fun `공백이 아닌 올바른 값 입력 시`() {
        val inputValidator = InputValidator()
        assertDoesNotThrow {
            inputValidator.checkBlank("NoBlank")
        }
    }

    @Test
    fun `양의 정수로 올바른 값 입력 시`() {
        val inputValidator = InputValidator()
        assertDoesNotThrow {
            inputValidator.checkForPositiveInteger("1")
        }
    }

    @Test
    fun `올바른 범위 내의 수 입력 시`() {
        val inputValidator = InputValidator()
        assertDoesNotThrow {
            inputValidator.checkForNumberRange("25")
        }
    }
}
