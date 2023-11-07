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
    @MethodSource("generateTestDataForCalculateProfit")
    @DisplayName("Calculator : calculateTotalProfit()")
    fun `로또 당첨 내역을 입력하면 총 수익금을 반환한다`(data: Pair<List<Int>, Long>) {
        // given
        val (countOfWin, expected) = data

        // when
        val actual = calculator.calculateTotalProfit(countOfWin)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateTestDataForCalculateProfitRate")
    @DisplayName("Calculator : calculateTotalProfitRate()")
    fun `총 수익금과 구매 장수를 입력하면 수익률을 반환한다`(data: Triple<Long, Int, Double>) {
        // given
        val (totalProfit, sizeOfTicket, expected) = data

        // when
        val actual = calculator.calculateProfitRate(totalProfit, sizeOfTicket)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateTestDataForCalculateProfit(): List<Pair<List<Int>, Long>> {
            return listOf(
                listOf(0, 0, 0, 0, 0, 0) to 0,
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

        @JvmStatic
        private fun generateTestDataForCalculateProfitRate(): List<Triple<Long, Int, Double>> {
            return listOf(
                Triple(5000L, 8, 0.625),
                Triple(5000L, 9, 0.556),
                Triple(55_000L, 10, 5.5),
                Triple(200_031_555_000L, 200, 1_000_157.775),
                Triple(16_000_000L, 7, 2_285.714),
                Triple(0L, 7, 0.0),
            )
        }
    }

}