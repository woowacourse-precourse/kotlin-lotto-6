package lotto.domain

import org.assertj.core.api.Assertions
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
    fun `로또 번호의 개수가 6개가 안 되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `getLottoNumbers 메서드 테스트 - 로또 번호 6개를 리스트 형태로 반환한다`() {
        val numbers = listOf(8, 21, 23, 41, 42, 43)
        val myLotto = Lotto(numbers)
        val lottoNumber = myLotto.getLottoNumbers()

        Assertions.assertThat(lottoNumber).isEqualTo(numbers)
    }
}
