package lotto.model

import lotto.model.dto.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개 보다 작으면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_OUT_OF_SIZE)
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_OUT_OF_SIZE)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }

        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_NON_DUPLICATE)
    }

    @Test
    fun `로또 번호와 (당첨 번호, 보너스 번호)를 비교하여 count 개수 반환`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers("1, 2, 3, 4, 5, 10")
        val bonusNumber = BonusNumber("6")

        val data = lotto.calculate(winningNumbers.numbers, bonusNumber.number)
        val lottoResult = LottoResult(winningMatchCount = 5, bonusMatchCount = 1)

        assertThat(data).isEqualTo(lottoResult)
    }
}
