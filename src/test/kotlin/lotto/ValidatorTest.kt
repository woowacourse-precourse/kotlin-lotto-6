package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.util.Validator.isValidPurchaseAmount
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    @DisplayName("구입 금액 입력이 유효하지 않다면 예외가 발생한다")
    fun validatePurchaseAmount () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("abcd")
            }
            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount(" ")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("-1000")
            }

            assertThrows<IllegalArgumentException> {
                isValidPurchaseAmount("8765")
            }
        }

    }
}