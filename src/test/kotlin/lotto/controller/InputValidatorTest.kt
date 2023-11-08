package lotto.controller

import lotto.controller.InputValidator.Companion.INVALID_DUPLICATE_NUMBER
import lotto.controller.InputValidator.Companion.INVALID_LOTTO_NUMBER
import lotto.controller.InputValidator.Companion.INVALID_LOTTO_NUMBERS_COUNT
import lotto.controller.InputValidator.Companion.INVALID_PURCHASE_AMOUNT
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class InputValidatorTest {

    private lateinit var validator: InputValidator

    @BeforeEach
    fun setUp() {
        validator = InputValidator()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 900, 100001])
    fun `1000 단위가 아닌 금액 입력 시 예외를 던진다`(input: Int?) {
        assertThrows<IllegalArgumentException>(INVALID_PURCHASE_AMOUNT) {
            validator.validatePurchaseAmount(input)
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbersCount")
    fun `로또 번호가 6자리가 아니라면 예외를 던진다`(numbers: List<Int?>) {
        assertThrows<IllegalArgumentException>(INVALID_LOTTO_NUMBERS_COUNT) {
            validator.validateLottoNumbers(numbers)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46, 100])
    fun `한 개의 로또 번호가 1~45 가 아니면 예외를 던진다`(input: Int) {
        assertThrows<IllegalArgumentException>(INVALID_LOTTO_NUMBER) {
            validator.validatePurchaseAmount(input)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateNumber")
    fun `보너스 번호가 기존 로또와 중복이 있으면 예외를 던진다`(bonusNumber: Int, numbers: List<Int>) {
        assertThrows<IllegalArgumentException>(INVALID_DUPLICATE_NUMBER) {
            validator.validateDuplicate(bonusNumber, numbers)
        }
    }


    companion object {
        @JvmStatic
        fun provideInvalidLottoNumbersCount(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1)),
                Arguments.of(listOf(1, 2, 3)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            )
        }

        @JvmStatic
        fun provideDuplicateNumber(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(2, listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(3, listOf(1, 2, 3, 4, 5, 6)),
            )
        }
    }
}


