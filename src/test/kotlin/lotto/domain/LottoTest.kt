package lotto.domain

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows



class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호에 1부터 45 사이의 숫자가 포함되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 50))
        }
    }

    @Test
    fun `로또 번호를 올바르게 가져온다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val getLottoNumbers = lotto.getLotto()
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThat(getLottoNumbers).isEqualTo(lottoNumbers)
    }
}
