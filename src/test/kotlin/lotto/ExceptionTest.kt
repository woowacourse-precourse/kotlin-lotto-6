package lotto

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {

    @Test
    fun `구입금액에 유효한 입력값이 들어왔을 때 DoesNotThrow`() {
        val input = "5000"

        assertDoesNotThrow { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `구입금액에 null 또는 빈 문자열이 들어왔을 때 예외처리`() {
        val input: String? = null

        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `구입금액에 숫자가 아닌 값이 들어왔을 때 예외처리`() {
        val input = "abc"

        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `구입금액에 1,000원 단위가 아닌 금액이 들어왔을 때 예외처리`() {
        val input = "1500"

        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `당첨번호에 유효한 입력값이 들어왔을 때 DoesNotThrow`() {
        val input = "1, 2, 3, 4, 5, 6"

        assertDoesNotThrow { Exception.enterWinningNumberException(input) }
    }

    @Test
    fun `당첨번호에 null 또는 빈 문자열이 들어왔을 때 예외처리`() {
        val input: String? = null

        assertThrows<IllegalArgumentException> { Exception.enterWinningNumberException(input) }
    }

    @Test
    fun `당첨번호에 숫자가 아닌 값이 포함되어 있을 때 예외처리`() {
        val input = "1, 2, abc, 4, 5, 6"

        assertThrows<IllegalArgumentException> { Exception.enterWinningNumberException(input) }
    }

    @Test
    fun `유효한 보너스 번호를 입력했을 때 정상적으로 반환하는지 확인`() {
        val input = "10"
        val winningNumbers = listOf(1, 2, 3, 4, 5)

        val result = Exception.enterBonusNumberException(input, winningNumbers)

        assertEquals(10, result)
    }

    @Test
    fun `보너스 번호가 중복되었을 때 예외가 발생하는지 확인`() {
        val input = "3"
        val winningNumbers = listOf(1, 2, 3, 4, 5)

        assertThrows<IllegalArgumentException> {
            Exception.enterBonusNumberException(input, winningNumbers)
        }
    }

    @Test
    fun `보너스 번호에 1부터 45 이외의 번호가 입력되었을 때 예외가 발생하는지 확인`() {
        val input = "50"
        val winningNumbers = listOf(1, 2, 3, 4, 5)

        assertThrows<IllegalArgumentException> {
            Exception.enterBonusNumberException(input, winningNumbers)
        }
    }

}
