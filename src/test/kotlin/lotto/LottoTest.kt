package lotto

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertThat(exception.message).isEqualTo(Lotto.INVALID_NUMBER_COUNT_ERROR_MESSAGE)
    }

    @Test
    fun `로또 번호의 범위가 1이상 45이하가 아니면 예외가 발생한다`() {
        // given
        val numbers = listOf(0, 2, 45, 4, 5, 6)

        // when
        val exception = assertThrows<IllegalArgumentException> { Lotto(numbers) }

        // then
        assertThat(exception.message).isEqualTo(Lotto.INVALID_RANGE_NUMBER)
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
}
