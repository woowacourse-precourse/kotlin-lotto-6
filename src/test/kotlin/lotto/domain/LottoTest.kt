package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.fromList(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.fromList(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호의 범위가 1 ~ 45에 해당하지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.fromList(listOf(10, 2, 3, 4, 5, 4))
        }
    }

    @Test
    fun `toString() 리턴 검증`() {
        val lotto = Lotto.fromList(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `toList() 로또 리스트 리턴 검증`() {
        val lotto = Lotto.fromList(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.toList()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `contains() 번호 체크 리턴 검증`() {
        val lotto = Lotto.fromList(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(1)).isEqualTo(true)
        assertThat(lotto.contains(2)).isEqualTo(true)
        assertThat(lotto.contains(7)).isEqualTo(false)
    }
}
