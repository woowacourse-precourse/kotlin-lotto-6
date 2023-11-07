package lotto.domain

import lotto.model.Bonus
import lotto.utils.Messages.ERROR_MESSAGE
import lotto.utils.Messages.INVALID_INPUT
import lotto.utils.Messages.MY_NUMBERS_OVER_RANGE_MESSAGE
import lotto.utils.Messages.VALIDATE_INPUT_EMPTY
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBonusTest {

    @Test
    fun `보너스 번호가 숫자가 아닐 경우`() {
        assertThrows<IllegalArgumentException> {
            val bonus = Bonus("wooteco")
        }
    }

    @Test
    fun `보너스 번호가 아무 입력이 없을 경우`() {
        try {
            Bonus("")
        } catch (e: IllegalArgumentException) {
            assertEquals("$ERROR_MESSAGE $VALIDATE_INPUT_EMPTY", e.message)
        }
    }

    @Test
    fun `보너스 번호 입력에 문자가 들어올 경우`() {
        try {
            Bonus("wooteco")
        } catch (e: IllegalArgumentException) {
            assertEquals("$ERROR_MESSAGE $INVALID_INPUT", e.message)
        }
    }

    @Test
    fun `보너스 번호 입력에 로또 번호 범위를 벗어난 경우`() {
        try {
            Bonus("100")
        } catch (e: IllegalArgumentException) {
            assertEquals("$ERROR_MESSAGE $MY_NUMBERS_OVER_RANGE_MESSAGE", e.message)
        }
    }
}