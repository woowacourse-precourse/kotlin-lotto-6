package lotto

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import lotto.Exception
import org.junit.jupiter.api.assertThrows

class ExceptionTest {

    @Test
    fun `purchaseAmountEntryException 유효한 입력값이 들어왔을 때 DoesNotThrow`() {
        // Arrange
        val input = "5000"

        // Act and Assert
        assertDoesNotThrow { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `purchaseAmountEntryException null 또는 빈 문자열이 들어왔을 때 예외처리`() {
        // Arrange
        val input: String? = null

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `purchaseAmountEntryException 숫자가 아닌 값이 들어왔을 때 예외처리`() {
        // Arrange
        val input = "abc"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `purchaseAmountEntryException 1,000원 단위가 아닌 금액이 들어왔을 때 예외처리`() {
        // Arrange
        val input = "1500"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exception.purchaseAmountEntryException(input) }
    }

    @Test
    fun `enterWinningNumberException 유효한 입력값이 들어왔을 때 DoesNotThrow`() {
        // Arrange
        val input = "1, 2, 3, 4, 5, 6"

        // Act and Assert
        assertDoesNotThrow { Exception.enterWinningNumberException(input) }
    }

    @Test
    fun `enterWinningNumberException null 또는 빈 문자열이 들어왔을 때 예외처리`() {
        // Arrange
        val input: String? = null

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exception.enterWinningNumberException(input) }
    }

    @Test
    fun `enterWinningNumberException 숫자가 아닌 값이 포함되어 있을 때 예외처리`() {
        // Arrange
        val input = "1, 2, abc, 4, 5, 6"

        // Act and Assert
        assertThrows<IllegalArgumentException> { Exception.enterWinningNumberException(input) }
    }

    // 나머지 테스트 케이스 작성하기

    // enterBonusNumberException에 대한 테스트도 작성해야 합니다.
}
