package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class LottoTest {
    @Test
    fun `로또 번호가 같으면 같은 동일한 로또 티켓이다`() {
        assertThat(Lotto(listOf(1, 2, 3, 4, 5, 6)) == Lotto(listOf(1, 2, 3, 4, 5, 6))).isTrue()
    }

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
    fun `로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생`() {
        assertThrows<IllegalArgumentException>("로또 번호는 1 ~ 45 사이여야 합니다") {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `로또 번호는 중복되면 예외 발생`() {
        assertThrows<IllegalArgumentException>("로또 번호는 중복되면 안됩니다") {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호가 오름차순 정렬이 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException>("로또 번호는 오름차순이여야 합니다") {
            Lotto(listOf(2, 3, 4, 5, 6, 1))
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"], delimiter = ':')
    fun `해당 로또 번호가 있는지 확인할 수 있다`(number: Int, expected: Boolean) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.contains(number)).isEqualTo(expected)
    }

    @Test
    fun `다른 로또와 같은 번호가 몇 개인지 알 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val otherLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

        assertThat(lotto.countMatch(otherLotto)).isEqualTo(5)
    }
}
