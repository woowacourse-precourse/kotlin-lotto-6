package lotto.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
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

    // test valid input case
    @ParameterizedTest
    @ValueSource(ints = [1000, 3000, 90000, 100000])
    fun `1000 단위 금액 입력 시 true 를 리턴한다`(input: Int) {
        val result = validator.validatePurchaseAmount(input)
        assertThat(result).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 10, 45])
    fun `한 개의 로또 번호가 1~45 이면 true 를 리턴한다`(input: Int) {
        val result = validator.validateNumber(input)
        assertThat(result).isEqualTo(true)
    }

    @ParameterizedTest
    @MethodSource("provideNormalLottoNumbers")
    fun `로또 번호가 6 자리이면 true 를 리턴한다`(numbers: List<Int>) {
        val result = validator.validateLottoNumbers(numbers)
        assertThat(result).isEqualTo(true)
    }

    @ParameterizedTest
    @MethodSource("provideNormalBonusANDNumbers")
    fun `보너스 번호가 기존 로또와 중복이 없으면 true 를 리턴한다`(bonusNumber: Int, numbers: List<Int>) {
        val result = validator.validateDuplicate(bonusNumber, numbers)
        assertThat(result).isEqualTo(true)
    }


    // test invalid input case
    @ParameterizedTest
    @ValueSource(ints = [-1000, 0, 900, 100001])
    fun `1000 단위가 아닌 금액 입력 시 false 를 리턴한다`(input: Int) {
        val result = validator.validatePurchaseAmount(input)
        assertThat(result).isEqualTo(false)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46, 100])
    fun `한 개의 로또 번호가 1~45 가 아니면 false 를 리턴한다`(input: Int) {
        val result = validator.validateNumber(input)
        assertThat(result).isEqualTo(false)
    }

    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbersCount")
    fun `로또 번호가 6자리가 아니라면 false 를 리턴한다`(numbers: List<Int>) {
        val result = validator.validateLottoNumbers(numbers)
        assertThat(result).isEqualTo(false)
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateNumber")
    fun `보너스 번호가 기존 로또와 중복이 있으면 false 를 리턴한다`(bonusNumber: Int, numbers: List<Int>) {
        val result = validator.validateDuplicate(bonusNumber, numbers)
        assertThat(result).isEqualTo(false)
    }

    companion object {

        @JvmStatic
        fun provideInvalidLottoNumbersCount(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
        )

        @JvmStatic
        fun provideDuplicateNumber(): Stream<Arguments> = Stream.of(
            Arguments.of(1, listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(2, listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(3, listOf(1, 2, 3, 4, 5, 6)),
        )


        @JvmStatic
        fun provideNormalLottoNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(1, 2, 33, 41, 15, 26)),
            Arguments.of(listOf(11, 22, 33, 14, 45, 36)),
        )

        @JvmStatic
        fun provideNormalBonusANDNumbers(): Stream<Arguments> = Stream.of(
            Arguments.of(7, listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(11, listOf(1, 2, 33, 41, 15, 26)),
            Arguments.of(31, listOf(11, 22, 33, 14, 45, 36)),
        )
    }
}


