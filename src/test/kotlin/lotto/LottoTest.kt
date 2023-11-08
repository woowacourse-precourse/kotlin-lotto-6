package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또번호와 당첨번호 그리고 보너스 번호를 비교한 결과 테스트`() {
        val lotto = Lotto(listOf(1, 3, 5, 7, 9, 11))
        val prizeLottoNumber = listOf(1, 3, 5, 13, 15, 17)
        val bonusNumber = 11
        val result = lotto.matchCount(prizeLottoNumber,bonusNumber)
        assertThat(result).isEqualTo(Pair(3,true))
    }
}
