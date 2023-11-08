package lotto.model

import lotto.model.validation.LottoNumber

import lotto.model.validation.WinningValidation
import lotto.util.Converter.toLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningValidationTest {
    @Test
    fun `당첨 번호와 보너스 번호 중 일치하는 숫자가 있으면, 예외가 발생한다`() {
        // TODO: 당첨 번호와 보너스 번호 입력시 중복이면, 예외 발생 테스트 구현
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6").toLottoNumbers()
        val bonusNumber = LottoNumber("6")

        val exception = assertThrows<IllegalArgumentException> {
            WinningValidation(winningNumbers, bonusNumber)
        }
        assertThat(exception.message).isEqualTo(WinningValidation.WINNING_BONUS_NUMBER_IS_NOT_DUPLICATE)
    }
}