package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("당첨 번호를 담고있는 class에서")
class WinningNumbersTest {

    @Test
    @DisplayName("정상적인 당첨번호가 입력되면 오류가 발생하지 않는다")
    fun normalWinningNumbers() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { WinningNumbers(numbers) }
    }

    @Test
    @DisplayName("당첨번호가 6개가 아니면 오류가 발생한다")
    fun notSixWinningNumbers() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5)
        //when
        //then
        Assertions.assertThatThrownBy { WinningNumbers(numbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("당첨번호가 중복되면 오류가 발생한다")
    fun duplicatedWinningNumbers() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 2)
        //when
        //then
        Assertions.assertThatThrownBy { WinningNumbers(numbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("당첨번호가 1~45사이에 없으면 오류가 발생한다")
    fun notInNormalNumberRangeWinningNumbers() {
        //given
        val numbers = listOf(1, 2, 3, 4, 5, 100)
        //when
        //then
        Assertions.assertThatThrownBy { WinningNumbers(numbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }


}