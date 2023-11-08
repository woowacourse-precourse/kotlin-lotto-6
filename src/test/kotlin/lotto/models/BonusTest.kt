package lotto.models

import lotto.models.Bonus
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `범위를 벗어난 보너스 번호인 경우 예외가 발생한다`(number: Int) {
        val exception = assertThrows<IllegalArgumentException> { Bonus(number) }

        assertThat(exception.message).isEqualTo(Bonus.NUMBER_RANGE_ERROR_MESSAGE)
    }

    @Test
    fun `범위 안의 보너스 번호인 경우 예외가 발생하지 않는다`() {
        val number = 1

        assertDoesNotThrow { Bonus(number) }
    }

    @Test
    fun `당첨 로또 번호와 중복되는 보너스 번호인 경우 예외가 발생한다`() {
        val bonus = Bonus(1)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val exception = assertThrows<IllegalArgumentException> { bonus.checkDistinctWithWinningLotto(winningNumbers) }

        assertThat(exception.message).isEqualTo(Bonus.DISTINCT_NUMBER_WITH_WINNING_LOTTO_ERROR_MESSAGE)
    }
}