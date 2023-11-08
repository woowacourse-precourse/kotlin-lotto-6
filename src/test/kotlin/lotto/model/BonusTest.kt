package lotto.model

import lotto.model.validator.BonusValidator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusTest {

    @Test
    fun `당첨 번호에 이미 포함된 번호를 보너스 번호로 입력했을 때, 오류를 반환한다`() {
        val winningNumbers = Lotto.of(1, 2, 3, 4, 5, 6)

        assertThatThrownBy {
            Bonus.of(numberInput = "1", winningNumbers = winningNumbers)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(BonusValidator.DUPLICATED_WINNING_NUMBERS_ERROR)
    }
}