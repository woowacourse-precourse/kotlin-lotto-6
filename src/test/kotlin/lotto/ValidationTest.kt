package lotto

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "lotto", "12_34"])
    fun `로또 구입 금액에 숫자가 아닌 값을 입력한 경우`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateOutOfRange(amount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "999", "4611686018001"])
    fun `로또 구입 금액에 정상 범위 밖의 값을 입력한 경우`(amount: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateOutOfRange(amount)
        }
    }

    @ParameterizedTest
    @ValueSource(longs = [1010, 1200, 13740417000010])
    fun `로또 구입 금액에 1000원 단위가 아닌 값을 입력한 경우`(num: Long) {
        assertThrows<IllegalArgumentException> {
            Validation.validateMoneyUnit(num)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateNumber")
    fun `로또 번호에 중복된 수가 존재하는 경우`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Validation.validateDuplicateNumber(numbers)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "lotto", "12_34"])
    fun `로또 번호에 숫자가 아닌 값을 입력한 경우`(str: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateLottoNumber(str)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "46"])
    fun `로또 번호에 정상 범위 밖의 값을 입력한 경우`(str: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateLottoNumber(str)
        }
    }

    @ParameterizedTest
    @MethodSource("provideWrongLengthNumber")
    fun `당첨 로또 번호에 6개의 숫자를 입력하지 않은 경우`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Validation.validateWrongLengthNumber(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateBonusNumber")
    fun `당첨 로또 번호에 존재하는 수를 보너스 번호에 입력한 경우`(bonusNumber: Int, winningNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            Validation.validateDuplicateBonusNumber(bonusNumber, winningNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun provideDuplicateNumber(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 5)),
            Arguments.of(listOf(10, 20, 30, 30, 40, 45))
        )

        @JvmStatic
        fun provideWrongLengthNumber(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(5, 10, 15, 20, 25, 30, 35, 40, 45))
        )

        @JvmStatic
        fun provideDuplicateBonusNumber(): Stream<Arguments> = Stream.of(
            Arguments.of(5, listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(30, listOf(5, 10, 20, 30, 40, 45))
        )
    }
}