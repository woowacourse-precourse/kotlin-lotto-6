import lotto.model.domain.Bonus
import lotto.model.domain.Lotto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BonusTest {

    @Test
    fun `Bonus와 winningNumbers가 중복되면 예외가 발생한다`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 6

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Bonus(bonusNumber, winningNumbers)
        }
    }

    @Nested
    inner class `Bonus가 1~45 범위 밖이면 예외가 발생한다` {

        @Test
        fun `Bonus가 1보다 작으면 예외가 발생한다`() {
            val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = 0

            Assertions.assertThrows(IllegalArgumentException::class.java) {
                Bonus(bonusNumber, winningNumbers)
            }
        }

        @Test
        fun `Bonus가 45보다 크면 예외가 발생한다`() {
            val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = 46

            Assertions.assertThrows(IllegalArgumentException::class.java) {
                Bonus(bonusNumber, winningNumbers)
            }
        }
    }
}
