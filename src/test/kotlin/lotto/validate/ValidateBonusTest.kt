package lotto.validate

import lotto.controller.LottoManager
import lotto.model.Bonus
import lotto.utils.Messages
import lotto.utils.Messages.ERROR_MESSAGE
import lotto.utils.Messages.INVALID_INPUT
import lotto.utils.Messages.MY_NUMBERS_OVER_RANGE_MESSAGE
import lotto.utils.Messages.VALIDATE_INPUT_EMPTY
import lotto.view.InputView
import lotto.view.OutputView
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidateBonusTest {
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

    @Test
    fun `보너스번호와 당첨번호에 중복이 존재할 경우`() {
        val lottoManager = LottoManager(InputView, OutputView)
        try {
            lottoManager.validateDuplicateBonusNumber(listOf(1,2,3,4,5,6), 1)
        } catch (e: IllegalArgumentException) {
            assertEquals("${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}", e.message)
        }

    }
}