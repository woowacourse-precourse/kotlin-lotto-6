package lotto

import lotto.domain.handleDuplicateNumbers
import lotto.domain.handleEmptyString
import lotto.domain.handleInvalidNumberOfNumbers
import lotto.domain.handleInvalidRange
import lotto.domain.handleNonCommaSeparated
import lotto.domain.handleNonInteger
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `당첨 번호를 입력하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleEmptyString(listOf(""))
        }
    }

    @Test
    fun `당첨 번호가 정수가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleNonInteger(listOf("1","2","3","3.5","4"))
        }
    }

    @Test
    fun `당첨 번호가 6개가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleInvalidNumberOfNumbers(listOf(1,2,3,4,5))
        }
    }

    @Test
    fun `당첨 번호 중 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleDuplicateNumbers(listOf(1,2,3,4,4,5))
        }
    }

    @Test
    fun `당첨 번호가 1 ~ 45 사이의 숫자가 아니면 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleInvalidRange(listOf(1,2,3,4,5,46))
        }
    }

    @Test
    fun `당첨 번호 쉼표(,)로 나눠지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            handleNonCommaSeparated("1,2,3,,4,5,6")
        }
    }
}