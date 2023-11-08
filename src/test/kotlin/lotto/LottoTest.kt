package lotto

import lotto.model.LottoNumber
import lotto.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.of(1, 2, 3, 4, 5, 6, 7)
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.of(1, 2, 3, 4, 5, 5)
        }
    }

    @Test
    fun `당첨 번호와 로또의 일치하는 값이 3개 있을 때, getMatchCount()의 결과 값으로 3을 반환한다`() {
        val winningNumbers = Lotto.of(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.of(1, 2, 3, 10, 12, 13)
        assertThat(winningNumbers.getMatchCount(lotto)).isEqualTo(3)
    }

    @Test
    fun `로또 번호 중 보너스 번호와 일치하는 값이 있다면, isMatchedBonus()를 호출했을 때 true를 반환한다`() {
        val lotto = Lotto.of(1, 2, 3, 4, 5, 6)
        assertThat(lotto.isMatchedBonus(bonus = LottoNumber(3))).isTrue()
        assertThat(lotto.isMatchedBonus(bonus = LottoNumber(10))).isFalse()
    }

    @Test
    fun toStringNumbersTest() {
        val lotto1 = Lotto.of(2, 40, 3, 4, 5, 10)
        val lotto2 = Lotto.create("2,40,3,4,5,10")
        val expected = "[2, 3, 4, 5, 10, 40]"

        assertThat(lotto1.toStringNumbers()).isEqualTo(expected)
        assertThat(lotto2.toStringNumbers()).isEqualTo(expected)
    }
}