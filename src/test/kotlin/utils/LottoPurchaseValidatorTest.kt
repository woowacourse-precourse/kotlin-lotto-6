package utils

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPurchaseValidatorTest {

    private val lottoPurchaseValidator = LottoPurchaseValidator()

    @Test
    fun When_NotDivisible_PurchaseAmount_Expect_InValid() {
        val input = "8500"
        assertThrows<IllegalArgumentException> { lottoPurchaseValidator.validateInvalidPurchaseAmount(input) }
    }

    @Test
    fun When_String_PurchaseAmount_Expect_Invalid() {
        val input = "hello"
        assertThrows<IllegalArgumentException> { lottoPurchaseValidator.validateIsString(input) }
    }

    @Test
    fun When_Negative_PurchaseAmount_Expect_Invalid() {
        val input = "-1000"
        assertThrows<IllegalArgumentException> { lottoPurchaseValidator.validateIsNegative(input) }
    }

    @Test
    fun When_Zero_PurchaseAmount_Expect_Invalid() {
        val input = "0"
        assertThrows<IllegalArgumentException> { lottoPurchaseValidator.validateIsZero(input) }
    }

    @Test
    fun When_Perfect_Valid_PurchaseAmount_Expect_Int() {
        val input = "8000"
        assertDoesNotThrow { lottoPurchaseValidator.checkInputValidation(input) }
    }
}