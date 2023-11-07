package lotto.validate

import lotto.utils.Messages
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateNumbersTest {
    val numbers = ValidateNumbers()
    @Test
    fun `입력된 당첨번호가 비어있는 경우`() {
        try {
            numbers.validateInputNumbers("")
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}", e.message)
        }
    }

    @Test
    fun `입력된 당첨번호가 쉼표로 구분되지 않은 경우`() {
        try {
            numbers.validateInputNumbers("1.2.3.4.5.6")
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DELIMITER_MESSAGE}", e.message)
        }
    }

}