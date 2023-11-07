package utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WinningNumbersValidatorTest {

    private val winningNumbersValidator = WinningNumbersValidator()

    @Test
    fun When_Input_4Numbers_Expect_InValid() {
        val input = "1,2,3,4".split(',')
        assertThrows<IllegalArgumentException> { winningNumbersValidator.validateNumbersCount(input) }
    }

    @Test
    fun When_Input_6Numbers_Expect_Valid() {
        val input = "11,22,33,44,55,66".split(',')
        assertDoesNotThrow { winningNumbersValidator.validateNumbersCount(input) }
    }

    @Test
    fun When_InClude_EmptySpace_Expect_InValid() {
        val input = ",1,2,3,4,5".split(',')
        assertThrows<IllegalArgumentException> { winningNumbersValidator.validateEmptySpace(input) }
    }

    @Test
    fun When_InClude_OutOfRange_Expect_InValid() {
        val input = "1,2,3,4,5,50".split(',').map { it.toInt() }
        assertThrows<IllegalArgumentException> { winningNumbersValidator.validateOutOfRangeNumbers(input) }
    }

    @Test
    fun When_Duplicate_Numbers_In_WinnerNumbers_Expect_InValid() {
        val input = "1,2,3,3,4,5".split(',').map { it.toInt() }
        assertThrows<IllegalArgumentException> { winningNumbersValidator.validateDuplicateNumbers(input) }
    }

    @Test
    fun When_6Numbers_InValidRange_Expect_Valid() {
        val input = "1,2,3,4,5,6"
        assert(winningNumbersValidator.checkInputValidation(input))
    }
}