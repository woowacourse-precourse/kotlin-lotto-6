package lotto.controller

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.util.stream.Stream

class LottoControllerTest {

    private lateinit var controller: LottoController

    @BeforeEach
    fun setUp() {
        controller = LottoController()
    }

    @Test
    fun `정상 범위 내의 1000원 단위인 로또 구입 금액 입력`() {
        assertDoesNotThrow {
            controller.checkLottoAmount("14000")
        }
    }

    @Test
    fun `정상 범위 내의 1000원 단위가 아닌 로또 구입 금액 입력`() {
        assertThrows<IllegalArgumentException> {
            controller.checkLottoAmount("14500")
        }
    }

    @Test
    fun `정상 범위 밖의 1000원 단위인 로또 구입 금액 입력`() {
        assertThrows<IllegalArgumentException> {
            controller.checkLottoAmount("4611686019000")
        }
    }

    @ParameterizedTest
    @MethodSource("provideProfit")
    fun `수익률을 올바르게 계산`(lottoResult: Map<Int, Int>, expense: Long) {
        val expected = BigDecimal("62.5")
        val actual = controller.calculatePrize(lottoResult, expense)
        assertEquals(0, expected.compareTo(actual))
    }

    companion object {
        @JvmStatic
        fun provideProfit(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(mapOf(3 to 1, 4 to 0, 5 to 0, 6 to 0, 50 to 0), 8000)
            )
        }
    }
}