package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PurchaseTest {
    @Test
    fun `구매 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외가 발생한다`() {
        val amounts = listOf(999, 1001, 1100)
        amounts.forEach { amount ->
            assertThrows<IllegalArgumentException> {
                Purchase(amount)
            }
        }
    }

    @Test
    fun `구매 금액이 0원 이하면 예외가 발생한다`() {
        val amounts = listOf(0, -1, -1000)
        amounts.forEach { amount ->
            assertThrows<IllegalArgumentException> {
                Purchase(amount)
            }
        }
    }

    @Test
    fun `구매 금액을 1000원으로 나눈만큼 로또들을 생성한다`() {
        val purchase = Purchase(amount = 20_000)
        val lottos = purchase.lottos
        assert(lottos.size == 20)
    }

    @ParameterizedTest
    @MethodSource("generate_Purchase_WinningResults_ProfitPercentage")
    fun `이익률을 정확히 계산한다 `(
        purchase: Purchase,
        winnings: List<Winning>,
        expectedProfitPercentage: Double
    ) {
        val actualProfitPercentage = purchase.calculateProfitPercentage(winnings)

        assert(actualProfitPercentage == expectedProfitPercentage) {
            "Actual: $actualProfitPercentage, Expected: $expectedProfitPercentage"
        }
    }

    companion object {
        @JvmStatic
        private fun generate_Purchase_WinningResults_ProfitPercentage(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Purchase(amount = 2000),
                    listOf(Winning.Six, Winning.None),
                    100_000_000.0
                ),
                Arguments.of(
                    Purchase(amount = 1000),
                    listOf(Winning.None),
                    0.0
                ),
                Arguments.of(
                    Purchase(amount = 4000),
                    listOf(
                        Winning.Six,
                        Winning.Six,
                        Winning.Six,
                        Winning.Six
                    ),
                    200_000_000.0
                )
            )
        }
    }
}
