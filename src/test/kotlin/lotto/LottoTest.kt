package lotto

import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoTest {
    //    @Test
//    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
//        }
//    }
//
//    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
//    @Test
//    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(1, 2, 3, 4, 5, 5))
//        }
//    }
//
//    // 아래에 추가 테스트 작성 가능
//    @Test
//    fun `로또 번호가 1~45가이면 예외가 발생한다`() {
//        assertThrows<IllegalArgumentException> {
//            Lotto(listOf(100, 2, 3, 4, 5, 5))
//        }
//    }
    @Test
    fun `당첨 갯수 확인`() {
        val result = Lotto(listOf(8, 21, 23, 41, 42, 43)).getWinningCount(Lotto(listOf(8, 21, 23, 41, 43, 44)))
        assertThat(result).isEqualTo(5)
    }
    @Test
    fun `보너스 확인`() {
        val result = Lotto(listOf(8, 21, 23, 41, 42, 43)).confirmBonusNumber(5,8)
        assertThat(result).isEqualTo(true)
    }
}
