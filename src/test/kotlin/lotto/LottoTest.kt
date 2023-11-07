package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it.toString()) })
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it.toString()) })
        }
    }

    @Test
    fun `로또 번호의 개수가 6개미만이라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5).map { LottoNumber(it.toString()) })
        }
    }

    @Test
    fun `로또 번호에 숫자가 아닌 입력이 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 'a').map { LottoNumber(it.toString()) })
        }
    }

    @Test
    fun `로또 번호에 1미만인 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 0).map { LottoNumber(it.toString()) })
        }
    }

    @Test
    fun `로또 번호에 45초과인 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46).map { LottoNumber(it.toString()) })
        }
    }
}
