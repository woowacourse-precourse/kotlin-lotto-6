package lotto

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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `생성한 로또 번호가 1 이상 45이하가 아니면 예외 발생`() {
        val numbers = generateLottoNumbers()
        assertThat(numbers).hasSize(6)
        assertThat(numbers).allSatisfy { it >= 1 && it <= 45 }
    }

    @Test
    fun `로또 번호에 중복이 있으면 예외가 발생한다`() {
        val numbers = generateLottoNumbers()
        assertThat(numbers.toSet()).hasSize(numbers.size)
    }


}
