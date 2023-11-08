package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class ValidationTest {

    @Test
    @DisplayName("구입 금액 입력 테스트")
    fun `숫자가 아닌 문자를 입력한 경우 예외 발생`() {
        val input = "횟수"
        assertThrows<IllegalArgumentException> {
            Validation.getPurchaseAmount(input)
        }
    }

    @Test
    @DisplayName("구입 금액 입력 테스트")
    fun `구입 단위가 1000원이 아닌 경우 예외 발생`() {
        val input = "1200"
        assertThrows<IllegalArgumentException> {
            Validation.getPurchaseAmount(input)
        }
    }

}