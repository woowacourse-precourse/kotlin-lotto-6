package lotto

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


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

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 번호 생성시 중복이 없어야 한다`() {
        val lotto = Lotto.createRandomLotto()
        assertTrue(lotto.getNumbers().distinct().size == 6)
    }

    @Test
    fun `로또 번호 생성시 숫자 범위가 1에서 45 사이여야 한다`() {
        val lotto = Lotto.createRandomLotto()
        assertTrue(lotto.getNumbers().all { it in 1..45 })
    }

    @Test
    fun `로또 번호와 특정 숫자를 비교하여 해당 숫자가 포함되어 있는지 확인할 수 있어야 한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.contains(3))
        assertFalse(lotto.contains(7))
    }
}