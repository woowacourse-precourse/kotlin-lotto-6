package lotto

import lotto.model.Lotto
import lotto.util.Converter.toLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개 보다 작으면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).toLottoNumbers())
        }
        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_OUT_OF_SIZE)
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).toLottoNumbers())
        }
        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_OUT_OF_SIZE)
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면, 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).toLottoNumbers())
        }

        assertThat(exception.message).isEqualTo(Lotto.LOTTO_NUMBERS_NON_DUPLICATE)
    }
}
