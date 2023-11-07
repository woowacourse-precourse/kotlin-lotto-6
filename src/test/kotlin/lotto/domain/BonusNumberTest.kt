package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("BonusNumber를 담는 class에서")
class BonusNumberTest {

    @Test
    @DisplayName("bonusNumber가 1~45 사이에 있으면 오류를 발생하지 않는다")
    fun normalBonusNumber() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { BonusNumber(5) }
    }

    @Test
    @DisplayName("bonusNumber가 1~45 밖에 있으면 오류가 발생한다")
    fun notInRangeBonusNumber() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { BonusNumber(50) }.isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("bonusNumber가 winning number들에 없는 숫자면 오류가 발생하지 않는다")
    fun notContainBonusNumberWinningNumber() {
        //given
        val bonusNumber = BonusNumber(5)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 6, 7))
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { bonusNumber.validateBonusNumber(winningNumbers) }
    }

    @Test
    @DisplayName("bonusNumber가 winning number들에 있는 숫자면 오류가 발생한다")
    fun containBonusNumberWinningNumber() {
        //given
        val bonusNumber = BonusNumber(5)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        //when
        //then
        Assertions.assertThatThrownBy { bonusNumber.validateBonusNumber(winningNumbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}