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

    @Test
    fun `범위 확인 메서드는 유효한 범위 내의 입력에 대해 예외를 던지지 않아야 함`() {
        val bonusNumber = BonusNumber()

        assertDoesNotThrow { bonusNumber.isBonusNumberRange(5) }
    }

    @Test
    fun `범위 확인 메서드는 범위를 벗어난 입력에 대해 예외를 던져야 함`() {
        val bonusNumber = BonusNumber()

        assertThrows<IllegalArgumentException> { bonusNumber.isBonusNumberRange(55) }
    }

    @Test
    fun `중복 확인 메서드는 중복되지 않은 입력에 대해 예외를 던지지 않아야 함`() {
        val bonusNumber = BonusNumber()
        val winningNumber = listOf(1, 2, 3)

        assertDoesNotThrow { bonusNumber.isBonusNumberDuplicate(4, winningNumber) }
    }

    @Test
    fun `중복 확인 메서드는 중복된 입력에 대해 예외를 던져야 함`() {
        val bonusNumber = BonusNumber()
        val winningNumber = listOf(1, 2, 3)

        assertThrows<IllegalArgumentException> { bonusNumber.isBonusNumberDuplicate(3, winningNumber) }
    }

}