package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import org.junit.jupiter.api.assertThrows

class BonusNumberValidatorTest {

    private val bonusNumberValidator = BonusNumberValidator()
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun When_Not_Exist_In_WinnerNumbers_Expect_Valid() {
        val input = 7
        assertDoesNotThrow { bonusNumberValidator.validateExistInWinningNumbers(input, winningNumbers) }
    }

    @Test
    fun When_Exist_In_WinnerNumbers_Expect_InValid() {
        val input = 3
        assertThrows<IllegalArgumentException> {
            bonusNumberValidator.validateExistInWinningNumbers(
                input,
                winningNumbers
            )
        }
    }
}