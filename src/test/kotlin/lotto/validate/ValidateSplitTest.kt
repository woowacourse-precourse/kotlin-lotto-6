package lotto.validate

import lotto.utils.Messages
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateSplitTest {
    private val numbers = ValidateSplit()
    @Test
    fun `입력된 당첨번호에 문자가 섞여있는 경우`() {
        try {
            numbers.validateSplitMyNumbers(listOf("1","2","3","4","5","육"))
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.INVALID_INPUT}", e.message)
        }
    }

    @Test
    fun `입력된 당첨번호에 빈 입력이 있는 경우`() {
        try {
            numbers.validateSplitMyNumbers(listOf("1","2","3","4","","6"))
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}", e.message)
        }
    }

    @Test
    fun `입력된 당첨번호에 중복된 입력이 있는 경우`() {
        try {
            numbers.validateSplitMyNumbers(listOf("1","2","3","4","4","6"))
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}", e.message)
        }
    }

    @Test
    fun `입력된 당첨번호가 범위를 벗어난 경우`() {
        try {
            numbers.validateSplitMyNumbers(listOf("100","2","3","4","5","6"))
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_OVER_RANGE_MESSAGE}", e.message)
        }
    }
}