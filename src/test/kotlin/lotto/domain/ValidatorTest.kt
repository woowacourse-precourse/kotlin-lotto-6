package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = Validator.getInstance()
    }

    @AfterEach
    fun tearDown() {
        Validator.releaseInstance()
    }

    @ParameterizedTest(name = "check {0}")
    @ValueSource(strings = ["1", "17", "500", "999", "1001", "20001", "100001"])
    @DisplayName("Validator : checkInputIsPositiveNum() - success")
    fun `checkInputIsPositiveNum 함수에 0보다 큰 양수 문자열 입력하면 true를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputIsPositiveNum(input)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "check {0}")
    @ValueSource(strings = ["천원", "10공0", "I000", "0", "-1", "-1000", "1 dollar", "lI00", "1000원", "2_000"])
    @DisplayName("Validator : checkInputIsPositiveNum() - fail")
    fun `checkInputIsPositiveNum 함수에 0보다 큰 양수가 아닌 문자열을 입력하면 false를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputIsPositiveNum(input)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,1,1,1", "1,5,7,45,100"])
    @DisplayName("Validator : checkInputIsConsistOfPositiveNum - success")
    fun `checkInputIsConsistOfPositiveNum 함수에 양식에 맞게 숫자를 입력하면 true를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputIsConsistOfPositiveNum(input)

        // then
        val expected = true
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, ", "1 ,2", "1,이,3,4", "0", "-1", "1,0", "1,-1", "", "일"])
    @DisplayName("Validator : checkInputIsConsistOfPositiveNum() - fail")
    fun `checkInputIsConsistOfPositiveNum 함수에 양식에 맞지 않는 값을 입력하면 false를 반환한다`(input: String) {
        // when
        val actual = validator.checkInputIsConsistOfPositiveNum(input)

        // then
        val expected = false
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateSuccessLottoNum")
    @DisplayName("Validator : checkLottoNumberIsCorrect() - true")
    fun `checkLottoNumberIsCorrect 함수에 양식에 맞는 값을 입력하면 아무것도 반환하지 않는다`(numbers: List<Int>) {
        // when
        val actual = validator.checkLottoNumberIsCorrect(numbers)

        // then
        val expected = Unit
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateOutOfRangeLottoNum")
    @DisplayName("Validator : checkLottoNumberIsCorrect() - fail(숫자 범위)")
    fun `1 ~ 45에 속하지 않는 로또 번호를 검증 함수에 넣으면 에러를 발생시킨다`(nums: List<Int>) {
        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkLottoNumberIsCorrect(nums)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.NUMBER_IS_NOT_IN_LOTTO_RANGE
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @ParameterizedTest
    @MethodSource("generateNotMatchedLength")
    @DisplayName("Validator : checkLottoNumberIsCorrect() - fail(입력 갯수)")
    fun `로또 번호를 6개가 아닌 갯수로 검증 함수에 넣으면 에러를 발생시킨다`(nums: List<Int>) {
        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkLottoNumberIsCorrect(nums)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.LENGTH_IS_NOT_CORRECT
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @ParameterizedTest
    @MethodSource("generateDuplicateLottoNum")
    @DisplayName("Validator : checkLottoNumberIsCorrect() - fail(중복)")
    fun `중복된 로또 번호를 검증 함수에 넣으면 에러를 발생시킨다`(nums: List<Int>) {
        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkLottoNumberIsCorrect(nums)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.DUPLICATE_IS_NOT_ALLOWED
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @ParameterizedTest
    @MethodSource("generateNotAscendingOrderedLottoNum")
    @DisplayName("Validator : checkLottoNumberIsCorrect() - fail(정렬)")
    fun `로또 번호를 오름차순으로 정렬하지 않고 검증 함수에 넣으면 에러를 발생시킨다`(nums: List<Int>) {
        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkLottoNumberIsCorrect(nums)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.NUMBER_SHOULD_BE_ORDERED
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-999", "-1", "0", "46", "999", "하나", "둘", "영", "1오", ""])
    @DisplayName("Validator : checkInputOfBonusCorrect() - fail(타입)")
    fun `1 ~ 45에 속하지 않는 보너스 번호를 입력하면 에러를 발생시킨다`(bonus: String) {
        // given
        val lotto = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkInputOfBonusCorrect(bonus, lotto)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.NUMBER_IS_NOT_IN_LOTTO_RANGE
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @Test
    fun `로또 번호와 중복된 보너스 번호를 입력하면 에러를 발생시킨다`() {
        // given
        val bonus = 1
        val lotto = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual: java.lang.IllegalArgumentException = assertThrows(IllegalArgumentException::class.java) {
            validator.checkInputOfBonusCorrect(bonus, lotto)
        }

        // then
        val expectedClass = IllegalArgumentException::class.java
        val expectedMessage = Validator.BONUS_SHOULD_NOT_BE_DUPLICATE
        assertThat(actual).isInstanceOf(expectedClass)
        assertThat(actual).hasMessageContaining(expectedMessage)
    }

    @Test
    fun `로또 번호와 중복되지 않은 보너스 번호를 입력하면 아무것도 반환하지 않는다`() {
        // given
        val bonus = 7
        val lotto = listOf(1, 2, 3, 4, 5, 6)

        // when
        val actual = validator.checkInputOfBonusCorrect(bonus, lotto)

        // the
        val expected = Unit
        assertThat(actual).isEqualTo(expected)
    }


    companion object {
        @JvmStatic
        private fun generateSuccessLottoNum(): List<List<Int>> {
            return listOf(
                listOf(1, 2, 3, 4, 5, 6),
                listOf(1, 5, 17, 24, 34, 45)
            )
        }

        @JvmStatic
        private fun generateOutOfRangeLottoNum(): List<List<Int>> {
            return listOf(
                listOf(-1, 2, 3, 4, 5, 6),
                listOf(0, 2, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 46),
                listOf(1, 2, 3, 4, 5, 199),
            )
        }

        @JvmStatic
        private fun generateNotMatchedLength(): List<List<Int>> {
            return listOf(
                listOf(),
                listOf(1),
                listOf(1, 2),
                listOf(1, 2, 3),
                listOf(1, 2, 3, 4),
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 2, 3, 4, 5, 6, 7, 8),
            )
        }

        @JvmStatic
        private fun generateDuplicateLottoNum(): List<List<Int>> {
            return listOf(
                listOf(1, 1, 3, 4, 5, 6),
                listOf(1, 2, 3, 4, 5, 5),
                listOf(1, 10, 15, 17, 45, 45),
            )
        }

        @JvmStatic
        private fun generateNotAscendingOrderedLottoNum(): List<List<Int>> {
            return listOf(
                listOf(2, 1, 3, 4, 5, 6),
                listOf(1, 2, 4, 3, 5, 6),
                listOf(1, 2, 3, 4, 6, 5),
                listOf(6, 5, 4, 3, 2, 1),
            )
        }
    }
}