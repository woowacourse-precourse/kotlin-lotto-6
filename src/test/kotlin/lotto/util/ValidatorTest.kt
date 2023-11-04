package lotto.util

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import lotto.util.Validator.validate1000Unit
import lotto.util.Validator.validateContain
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateLottoInteger
import lotto.util.Validator.validateLottoRange
import lotto.util.Validator.validateLottoLength
import lotto.util.Validator.validateLottoUnique
import lotto.util.Validator.validateNotNull
import lotto.util.Validator.validateNumberRange
import lotto.util.Validator.validateRange
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

            assertThrows<IllegalArgumentException> {
                validateRange("${Int.MAX_VALUE.toLong() + 1}")
            }
        }
    }

    @Test
    @DisplayName("로또 구매 가격이 1000원 단위가 아니면 예외가 발생한다.")
    fun validate1000UnitTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validate1000Unit("1001")
            }

            assertThrows<IllegalArgumentException> {
                validate1000Unit("2001")
            }

            assertThrows<IllegalArgumentException> {
                validate1000Unit("10001")
            }
        }
    }

    @Test
    @DisplayName("로또 당첨 번호에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    fun validateLottoIntegerTest() {
        assertThrows<IllegalArgumentException> {
            validateLottoInteger("a,b,1,c")
        }
    }

    @Test
    @DisplayName("당첨번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    fun validateLottoRangeTest() {
        assertThrows<IllegalArgumentException> {
            validateLottoRange(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    @DisplayName("당첨번호의 숫자가 6자리가 아닐 시 예외가 발생한다.")
    fun validateLottoLengthTest() {
        assertThrows<IllegalArgumentException> {
            validateLottoLength(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    @DisplayName("당첨번호의 숫자에 중복이 있으면 예외가 발생한다.")
    fun validateLottoUniqueTest() {
        assertThrows<IllegalArgumentException> {
            validateLottoUnique(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("입력이 널값이면 예외가 발생한다.")
    fun validateNotNullTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateNotNull("")
            }

            assertThrows<IllegalArgumentException> {
                validateNotNull(" ")
            }
        }
    }

    @Test
    @DisplayName("번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    fun validateNumberRangeTest() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                validateNumberRange(0)
            }

            assertThrows<IllegalArgumentException> {
                validateNumberRange(46)
            }
        }
    }

    @Test
    @DisplayName("검증 값이 주어진 리스트에 중복된 값이면 예외가 발생한다.")
    fun validateContainTest() {
        assertThrows<IllegalArgumentException> {
            validateContain(listOf(1, 2, 3, 4, 5, 6), 4)
        }
    }
}