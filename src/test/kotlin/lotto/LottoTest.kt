package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.NumberIssuer
import lotto.utils.Constant.LOTTO_NUMBER_SIZE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

private const val OUT_RANGE_NUMBER = 46
class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) })
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) })
        }
    }

    // 아래에 추가 테스트 작성 가능

    @Test
    fun `발행된 로또 숫자의 범위가 1~45 사이가 아니면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(OUT_RANGE_NUMBER)
        }
    }

}
