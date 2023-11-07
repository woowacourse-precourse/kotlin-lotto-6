package lotto

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
    fun When_6MatchNumbers_Expect_6() {
        val input = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = 6
        assert(input.countSameNumber(listOf(1, 2, 3, 4, 5, 6)) == expected)
    }

    @Test
    fun When_3MatchNumbers_Expect_3() {
        val input = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = 3
        assert(input.countSameNumber(listOf(1, 2, 3, 7, 8, 9)) == expected)
    }

    @Test
    fun When_0MatchNumber_Expect_0() {
        val input = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val expected = 0
        assert(input.countSameNumber(listOf(7, 8, 9, 10, 11, 12)) == expected)
    }
}
