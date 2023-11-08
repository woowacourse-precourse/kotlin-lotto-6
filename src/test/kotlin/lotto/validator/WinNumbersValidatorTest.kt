package lotto.validator

import lotto.constant.Constants.COUNT
import lotto.constant.Constants.END_INCLUSIVE
import lotto.constant.Constants.START_INCLUSIVE
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinNumbersValidatorTest : InputValidator() {

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `공백 or 아무 것도 입력하지 않았을 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinNumbersValidator(listOf(value))
        }

        assertEquals("[ERROR] 공백을 제외한 값을 입력해 주세요", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "-2000", "#421", "421#", "가나다"])
    fun `양의 정수가 아닐 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinNumbersValidator(listOf(value))
        }

        assertEquals("[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "46"])
    fun `범위 밖의 수 입력 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            WinNumbersValidator(listOf(value))
        }

        assertEquals("[ERROR] 로또 번호는 ${START_INCLUSIVE}부터 ${END_INCLUSIVE}사이만 가능합니다", exception.message)
    }

    @Test
    fun `중복된 값 입력 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinNumbersValidator(listOf("1", "1", "2", "3", "4", "5"))
        }

        assertEquals("[ERROR] 중복된 값이 존재합니다", exception.message)
    }

    @Test
    fun `COUNT개 미만 입력 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            WinNumbersValidator(listOf("1", "2", "3", "4", "5"))
        }

        assertEquals("[ERROR] 당첨 번호는 ${COUNT}개가 필요합니다", exception.message)
    }

    @Test
    fun `올바른 값 입력 시`() {
        assertDoesNotThrow {
            WinNumbersValidator(listOf("11", "22", "33", "41", "35", "26"))
        }
    }
}
