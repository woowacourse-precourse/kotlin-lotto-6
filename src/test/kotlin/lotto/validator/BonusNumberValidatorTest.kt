package lotto.validator

import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.START_INCLUSIVE
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {
    private val winNumbers = listOf(1, 2, 3, 4, 5, 6)

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `공백 or 아무 것도 입력하지 않았을 때`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(winNumbers, value)
        }

        assertEquals("[ERROR] 공백을 제외한 값을 입력해 주세요", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "-2000", "#421", "421#", "가나다"])
    fun `양의 정수 이외의 숫자를 입력했을 때`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(winNumbers, value)
        }

        assertEquals("[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46"])
    fun `범위 밖의 수 입력 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(winNumbers, value)
        }

        assertEquals("[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다", exception.message)
    }

    @Test
    fun `당첨번호와 중복된 값 입력 시`() {
        val duplicateBonusNumber = "1"

        val exception = assertThrows<IllegalArgumentException> {
            BonusNumberValidator(winNumbers, duplicateBonusNumber)
        }

        assertEquals("[ERROR] 당첨 번호와 중복되지 않은 값을 입력해 주세요", exception.message)
    }

    @Test
    fun `올바른 값 입력 시`() {
        assertDoesNotThrow {
            BonusNumberValidator(winNumbers, "35")
        }
    }
}
