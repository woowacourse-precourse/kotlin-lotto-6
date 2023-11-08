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

    @Test
    fun `로또 번호에 1 미만의 숫자가 있으면 에외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호에 45 초과의 숫자가 있으면 에외 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 44, 45, 46))
        }
    }

    @Test
    fun `로또 번호를 오름차순으로 정렬하여 반환한다`() {
        assertThat(Lotto(listOf(6, 5, 4, 3, 2, 1)).toAscendingList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }
}
