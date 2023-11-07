package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    fun lottoInvalidLengthTest() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    fun lottoInvalidUniqueTest() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("로또 번호에 유효하지 않은 범위의 숫자가 있으면 예외가 발생한다.")
    fun lottoInvalidRangeTest() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    @DisplayName("로또 번호를 올바르게 가져오는지 테스트한다.")
    fun lottoGetNumberTest(){
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val validation = lotto.getWinningNumbers()
        val result = listOf(1, 2, 3, 4, 5, 6)
        assertThat(validation).isEqualTo(result)
    }
}
