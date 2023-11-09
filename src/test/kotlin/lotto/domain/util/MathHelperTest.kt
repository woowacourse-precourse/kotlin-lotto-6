package lotto.domain.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MathHelperTest {
    private lateinit var mathHelper: MathHelper

    @BeforeEach
    fun setUp() {
        mathHelper = MathHelper()
    }

    @ParameterizedTest
    @CsvSource(
        "2000000, 2, 100000.0",
        "1500000, 3, 50000.0",
        "50000, 4, 1250.0",
        "5000, 5, 100.0",
    )
    fun `총 수익률 계산기`(totalAmount: Int, ticketCount: Int, actualWinRate: Float) {
        val expectedWinRate = mathHelper.calculateWinRate(totalAmount, ticketCount)

        assertEquals(expectedWinRate, actualWinRate)
    }

    @ParameterizedTest
    @CsvSource(
        "123.456, 123.5",
        "0.0, 0.0",
        "0.12, 0.1",
        "123.431, 123.4",
        "1000.03, 1000.0",
        "1000.91, 1000.9",
        "1000.96, 1001.0",
        )
    fun `소수점 테스트`(input: Float, actualWinRate: String) {
        val expectedWinRate = mathHelper.roundToFirstDecimalPlace(input)

        assertEquals(expectedWinRate, actualWinRate)
    }
}