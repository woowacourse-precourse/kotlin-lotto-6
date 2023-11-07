package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Lotto번호들을 담는 class에서")
class LottoTest {

    @Test
    @DisplayName("정상적인 번호들이면 오류가 발생하지 않는다")
    fun normalNumber() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { Lotto(numbers) }
    }

    @Test
    @DisplayName("번호가 6개가 아니면 오류가 발생한다")
    fun notSixNumber() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5)
        //when
        //then
        Assertions.assertThatThrownBy { Lotto(numbers) }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("중복된 번호가 있으면 오류가 발생한다")
    fun duplicatedNumber() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 1)
        //when
        //then
        Assertions.assertThatThrownBy { Lotto(numbers) }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    @DisplayName("lotto 번호와 당첨번호를 비교해서 같은 수의 갯수를 반환한다")
    fun containWinningNumbers() {
        //given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(3, 4, 5, 6, 7, 8))
        //when
        //then
        Assertions.assertThat(lotto.compareWinningNumbers(winningNumbers)).isEqualTo(4)
    }

    @Test
    @DisplayName("lotto 번호와 bonus 번호를 비교해서 포함하면 1울 반환한다")
    fun containBonusNumber() {
        //given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(4)
        //when
        //then
        Assertions.assertThat(lotto.compareBonusNumber(bonus)).isEqualTo(1)
    }

    @Test
    @DisplayName("lotto 번호와 bonus 번호를 비교해서 포함하지 않으면 0울 반환한다")
    fun notContainBonusNumber() {
        //given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = BonusNumber(7)
        //when
        //then
        Assertions.assertThat(lotto.compareBonusNumber(bonus)).isEqualTo(0)
    }
}