package lotto.util

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
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("로또 구매 가격이 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = ["abcd", "1234!, `1234"])
    fun validateIntegerTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateInteger(input)
        }
    }

    @ParameterizedTest
    @DisplayName("로또 구매 가격의 범위가 유효하지 않으면 예외가 발생한다.")
    @ValueSource(ints = [-1000, 999, 0])
    fun validateRangeTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            validateRange(input)
        }
    }

    @ParameterizedTest
    @DisplayName("로또 구매 가격이 1000원 단위가 아니면 예외가 발생한다.")
    @ValueSource(ints = [1001, 2001, 9999])
    fun validate1000UnitTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            validate1000Unit(input)
        }
    }

    @ParameterizedTest
    @DisplayName("로또 당첨 번호에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @ValueSource(strings = ["a,b,1,c", "1,2,3,_"])
    fun validateLottoIntegerTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateLottoInteger(input)
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

    @ParameterizedTest
    @DisplayName("입력이 널값이면 예외가 발생한다.")
    @ValueSource(strings = ["", " ", "             "])
    fun validateNotNullTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validateNotNull(input)
        }
    }

    @ParameterizedTest
    @DisplayName("번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @ValueSource(ints = [0, 46, -1])
    fun validateNumberRangeTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            validateNumberRange(input)
        }
    }

    @ParameterizedTest
    @DisplayName("검증 값이 주어진 리스트에 중복된 값이면 예외가 발생한다.")
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun validateContainTest(input: Int) {
        assertThrows<IllegalArgumentException> {
            validateContain(listOf(1, 2, 3, 4, 5, 6), input)
        }
    }
}