package lotto

import lotto.model.BonusNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {

    @Test
    fun `숫자 확인 메서드는 유효한 입력에 대해 예외를 던지지 않아야 함`() {
        val bonusNumber = BonusNumber()

        assertDoesNotThrow { bonusNumber.isBonusNumberNumeric("10") }
    }

    @Test
    fun `숫자 확인 메서드는 유효하지 않은 입력에 대해 예외를 던져야 함`() {
        val bonusNumber = BonusNumber()

        assertThrows<IllegalArgumentException> { bonusNumber.isBonusNumberNumeric("abc") }
    }
}