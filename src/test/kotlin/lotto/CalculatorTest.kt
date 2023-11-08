package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class CalculatorTest {

    @Test
    fun `주어진 로또번호의 3개 당첨여부가 일치하는지 테스트`() {
        Assertions.assertAll(
            Executable { assertEquals(true, calculator.is3Jackpot(lotto, listOf(1, 2, 3, 40, 41, 42))) },
            Executable {
                assertEquals(
                    true,
                    calculator.is3Jackpot(Lotto(listOf(1, 3, 5, 14, 22, 45)), listOf(1, 2, 3, 4, 5, 6))
                )
            },
        )
    }

    @Test
    fun `주어진 로또번호의 4개 당첨여부가 일치하는지 테스트`() {
        Assertions.assertAll(
            Executable { assertEquals(false, calculator.is5Jackpot(lotto, listOf(1, 2, 3, 40, 41, 42))) },
            Executable { assertEquals(true, calculator.is4Jackpot(lotto, listOf(1, 2, 3, 4, 8, 9))) },
        )
    }

    @Test
    fun `주어진 로또번호의 5개 당첨여부가 일치하는지 테스트`() {
        Assertions.assertAll(
            Executable { assertEquals(false, calculator.is5Jackpot(lotto, listOf(1, 2, 3, 40, 41, 42))) },
            Executable { assertEquals(true, calculator.is5Jackpot(lotto, listOf(1, 2, 3, 4, 5, 9))) }
        )
    }

    @Test
    fun `주어진 로또번호의 5개와 보너스 볼 당첨여부가 일치하는지 테스트`() {
        Assertions.assertAll(
            Executable {
                assertEquals(
                    false, calculator.is5JackpotWithBonus(
                        lotto, bonus, listOf(1, 2, 3, 4, 5, 6), bonus
                    )
                )
            },
            Executable {
                assertEquals(
                    true, calculator.is5JackpotWithBonus(
                        lotto, bonus, listOf(1, 2, 3, 4, 5, 9), bonus
                    )
                )
            }
        )

    }

    @Test
    fun `주어진 로또번호의 6개 당첨여부가 일치하는지 테스트`() {
        Assertions.assertAll(
            Executable { assertEquals(false, calculator.is6Jackpot(lotto, listOf(1, 2, 3, 4, 5, 43))) },
            Executable { assertEquals(true, calculator.is6Jackpot(lotto, listOf(1, 2, 3, 4, 5, 6))) }
        )

    }

    companion object {
        lateinit var calculator: Calculator
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 10

        @BeforeAll
        @JvmStatic
        fun setUp() {
            calculator = Calculator()
        }
    }
}