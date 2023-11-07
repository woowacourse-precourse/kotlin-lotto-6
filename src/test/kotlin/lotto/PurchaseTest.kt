package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import lotto.model.Purchase
import lotto.model.Winning
import lotto.model.WinningNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
        val purchase = Purchase(amountWon = 20_000)
        assert(purchase.lottoCount == 20)
    }

    @Test
    fun `구매 정보를 당첨 번호와 확인 했을 때 올바른 수익률을 생성한다`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val amountWon = 1_000
                val purchase = Purchase(amountWon = amountWon)
                val winningNumber = WinningNumber(
                    normalNumbers = listOf(1, 2, 3, 4, 5, 6),
                    bonusNumber = 7
                )

                val statics = purchase.check(winningNumber)

                val actual = Winning.Six.priceWon.toDouble() / amountWon * 100
                assert(statics.profitPercentage == actual)
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }

    @Test
    fun `구매 정보를 당첨 번호와 확인 했을 때 올바른 당첨 개수를 생성한다`() {
        assertRandomUniqueNumbersInRangeTest(
            {
                val amountWon = 1_000
                val purchase = Purchase(amountWon = amountWon)
                val winningNumber = WinningNumber(
                    normalNumbers = listOf(1, 2, 3, 4, 5, 6),
                    bonusNumber = 7
                )

                val statics = purchase.check(winningNumber)

                val winnings = Winning.values()
                winnings.forEach { winning ->
                    val count = statics.countOf(winning)
                    when (winning) {
                        Winning.Six -> assert(count == 1)
                        else -> assert(count == 0)
                    }
                }
            },
            listOf(1, 2, 3, 4, 5, 6),
        )
    }
}
