package lotto.validator

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchasePriceValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `구입 금액으로 공백을 입력 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchasePriceValidator(value)
        }

        assertEquals("[ERROR] 공백을 제외한 값을 입력해 주세요", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "-2000", "#421", "421#"])
    fun `양의 정수가 아닌 문자 입력 시`(value: String) {
        val exception = assertThrows<IllegalArgumentException> {
            PurchasePriceValidator(value)
        }

        assertEquals("[ERROR] 양의 정수 이외의 숫자를 입력하지 말아주세요", exception.message)
    }

    @Test
    fun `1000원 미만의 금액 입력 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            PurchasePriceValidator("500")
        }

        assertEquals("[ERROR] 최소 1,000원 이상을 입력해 주세요", exception.message)
    }

    @Test
    fun `1000원 단위가 아닌 금액 입력 시`() {
        val exception = assertThrows<IllegalArgumentException> {
            PurchasePriceValidator("1100")
        }

        assertEquals("[ERROR] 1,000원 단위로 입력해 주세요", exception.message)
    }

    @Test
    fun `1000원 이상 입력 시`() {
        assertDoesNotThrow { PurchasePriceValidator("1000") }
    }

    @Test
    fun `올바른 값 입력 시`() {
        assertDoesNotThrow {
            PurchasePriceValidator("3000")
        }
    }
}
