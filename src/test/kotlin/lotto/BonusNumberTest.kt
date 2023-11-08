package lotto

import lotto.domain.handleInvalidNumber
import lotto.domain.handleInvalidRange
import lotto.domain.handleNonInteger
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `보너스 번호를 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleInvalidNumber(" ")
        }
    }

    @Test
    fun `보너스 번호가 정수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleNonInteger("2.3")
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleInvalidRange(46)
        }
    }
}