package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.util.Validator.validateInteger
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    @DisplayName("로또 구매 가격이 숫자가 아니면 예외가 발생한다.")
    fun validateIntegerTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateInteger("abcd")
            }

            assertThrows<IllegalArgumentException> {
                validateInteger("1245!")
            }
        }
    }

    @Test
    @DisplayName("로또 구매 가격의 범위가 유효하지 않으면 예외가 발생한다.")
    fun validateRangeTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateRange("-1000")
            }

            assertThrows<IllegalArgumentException> {
                validateRange("999")
            }

            assertThrows<IllegalArgumentException> {
                validateRange("0")
            }
        }
    }
}