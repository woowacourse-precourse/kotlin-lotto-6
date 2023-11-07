package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("lotto들의 list를 담는 class에서")
class LottosTest {

    @Test
    @DisplayName("lotto게임의 결과를 반환한다")
    fun calculateGameResult() {
        //given
        val lottos = Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        val winningNumbers = WinningNumbers(listOf(4, 5, 6, 7, 8, 9))
        val bonusNumber = BonusNumber(3)
        val purchaseAmount = 1000
        //when
        val result = lottos.calculateGameResult(winningNumbers, bonusNumber)
        //then
        Assertions.assertThat(result.calculateEarningRate(purchaseAmount)).contains("5000")
    }

    @Test
    @DisplayName("lotto들의 번호를 반환한다")
    fun toLottosResult() {
        //given
        val lottos = Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))))
        //when
        val numbers = lottos.toLottosResult()
        //then
        Assertions.assertThat(numbers).contains("1, 2, 3, 4, 5, 6")
    }
}