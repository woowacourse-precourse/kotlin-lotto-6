package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `몫과 나머지를 구하는 함수에 10,000과 1,000을 입력하면 10, 0을 반환한다`() {
        // given
        val dividend = 10_000u
        val divisor = 1_000u

        // when
        val actual = calculator.getQuotientAndRemainder(dividend, divisor)

        // then
        val expected = 10 to 0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `몫과 나머지를 구하는 함수에 9,123과 1,000을 입력하면 9, 123을 반환한다`() {
        // given
        val dividend = 9_123u
        val divisor = 1_000u

        // when
        val actual = calculator.getQuotientAndRemainder(dividend, divisor)

        // then
        val expected = 9 to 123
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `몫과 나머지를 구하는 함수에 999과 1,000을 입력하면 0, 999를 반환한다`() {
        // given
        val dividend = 999u
        val divisor = 1_000u

        // when
        val actual = calculator.getQuotientAndRemainder(dividend, divisor)

        // then
        val expected = 0 to 999
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateTestDataForCalculateProfitRate")
    @DisplayName("Calculator : calculateTotalProfit()")
    fun `로또 당첨 내역을 입력하면 총 수익금을 반환한다`(data: Pair<List<Int>, Long>) {
        // given
        val (countOfWin, expected) = data

        // when
        val actual = calculator.calculateTotalProfit(countOfWin)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateTestDataForCalculateProfitRate(): List<Pair<List<Int>, Long>> {
            return listOf(
                listOf(7, 0, 0, 0, 0, 1) to 5_000,
                listOf(0, 0, 0, 0, 0, 1) to 5_000,
                listOf(0, 0, 0, 0, 0, 3) to 15_000,
                listOf(0, 0, 0, 0, 1, 1) to 55_000,
                listOf(0, 0, 0, 1, 1, 1) to 1_555_000,
                listOf(0, 0, 1, 1, 1, 1) to 31_555_000,
                listOf(0, 1, 1, 1, 1, 1) to 2_031_555_000,
                listOf(0, 10, 1, 1, 1, 1) to 20_031_555_000,
                listOf(0, 100, 1, 1, 1, 1) to 200_031_555_000,
                listOf(0, 6, 7, 12, 5, 4) to 12_228_270_000,
            )
        }
    }

}