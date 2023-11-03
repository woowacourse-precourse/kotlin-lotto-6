package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    @DisplayName("로또 구매 가격이 숫자가 아니면 예외가 발생한다.")
    fun validateIntegerTest() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> {
                validateInteger("abcd")
            }

            assertThrows<IllegalArgumentException> {
                validateInteger("1245!")
            }
        }
    }
}