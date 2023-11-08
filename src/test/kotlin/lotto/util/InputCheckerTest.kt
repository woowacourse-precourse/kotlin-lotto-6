package lotto.util

import lotto.TestCaseArguments.CHECK_INPUT_BONUS_TEST_CASE_FAIL_DUPLICATE
import lotto.TestCaseArguments.CHECK_INPUT_BONUS_TEST_CASE_FAIL_NOT_NUMBER
import lotto.TestCaseArguments.CHECK_INPUT_BONUS_TEST_CASE_FAIL_NOT_RANGE
import lotto.TestCaseArguments.CHECK_INPUT_BONUS_TEST_CASE_SUCCESS
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_DUPLICATE
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_LOTTO_SIZE
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_NUMBER
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_RANGE
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_FIRST
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_SECOND
import lotto.TestCaseArguments.CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_THIRD
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class InputCheckerTest {

    @Nested
    @DisplayName("입력받은 문자열을 Money 규칙대로 검사하고 Int로 반환하는 함수 테스트")
    inner class CheckInputMoneyTest {

        @ParameterizedTest
        @CsvSource("1000, -1, 1000", "230000, -1, 230000", "384173000, -1, 384173000")
        fun success(money: String, returnCode: Int, output: Int) {
            val result = InputChecker.checkInputMoney(money, returnCode)
            Assertions.assertEquals(output, result)
        }

        @ParameterizedTest
        @CsvSource("2147483000, -1, -1", "10000원, -1, -1", "500, -1 ,-1", "23500, -1, -1")
        fun fail(money: String, returnCode: Int, output: Int) {
            val result = InputChecker.checkInputMoney(money, returnCode)
            Assertions.assertEquals(output, result)
        }
    }

    @Nested
    @DisplayName("입력받은 문자열을 Numbers 규칙대로 검사하고 List<Int>로 반환하는 함수 테스트")
    inner class CheckInputNumbersTest {

        @ParameterizedTest
        @MethodSource("lotto.util.InputCheckerTest#getCheckInputNumberArgumentSuccess")
        fun success(numbers: String, returnCode: List<Int>, output: List<Int>) {
            val result = InputChecker.checkInputNumbers(numbers, returnCode)
            Assertions.assertEquals(output, result)
        }

        @ParameterizedTest
        @MethodSource("lotto.util.InputCheckerTest#getCheckInputNumberArgumentFail")
        fun fail(money: String, returnCode: List<Int>, output: List<Int>) {
            val result = InputChecker.checkInputNumbers(money, returnCode)
            Assertions.assertEquals(output, result)
        }
    }

    @Nested
    @DisplayName("입력받은 문자열을 Bonus 규칙대로 검사하고 Int로 반환하는 함수 테스트")
    inner class CheckInputBonusTest {

        @ParameterizedTest
        @MethodSource("lotto.util.InputCheckerTest#getCheckInputBonusArgumentSuccess")
        fun success(lottoNumbers: List<Int>, inputString: String, returnCode: Int, output: Int) {
            val result = InputChecker.checkInputBonus(lottoNumbers, inputString, returnCode)
            Assertions.assertEquals(output, result)
        }

        @ParameterizedTest
        @MethodSource("lotto.util.InputCheckerTest#getCheckInputBonusArgumentFail")
        fun fail(lottoNumbers: List<Int>, inputString: String, returnCode: Int, output: Int) {
            val result = InputChecker.checkInputBonus(lottoNumbers, inputString, returnCode)
            Assertions.assertEquals(output, result)
        }
    }

    companion object {
        @JvmStatic
        fun getCheckInputNumberArgumentSuccess(): Stream<Arguments> = Stream.of(
            CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_FIRST,
            CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_SECOND,
            CHECK_INPUT_NUMBERS_TEST_CASE_SUCCESS_THIRD,
        )

        @JvmStatic
        fun getCheckInputNumberArgumentFail(): Stream<Arguments> = Stream.of(
            CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_LOTTO_SIZE,
            CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_NUMBER,
            CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_NOT_RANGE,
            CHECK_INPUT_NUMBERS_TEST_CASE_FAIL_DUPLICATE,
        )

        @JvmStatic
        fun getCheckInputBonusArgumentSuccess(): Stream<Arguments> = Stream.of(
            CHECK_INPUT_BONUS_TEST_CASE_SUCCESS
        )

        @JvmStatic
        fun getCheckInputBonusArgumentFail(): Stream<Arguments> = Stream.of(
            CHECK_INPUT_BONUS_TEST_CASE_FAIL_NOT_NUMBER,
            CHECK_INPUT_BONUS_TEST_CASE_FAIL_NOT_RANGE,
            CHECK_INPUT_BONUS_TEST_CASE_FAIL_DUPLICATE,
        )
    }
}