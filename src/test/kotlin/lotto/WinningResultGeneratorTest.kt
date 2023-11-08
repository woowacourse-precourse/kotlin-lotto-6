package lotto

import lotto.data.Lotto
import lotto.data.Money
import lotto.data.Winning
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WinningResultGeneratorTest {
    val winningResultGenerator = WinningResultGenerator()
    private val lotto = Lotto(listOf(1,2,3,4,5,6))
    private val lotteryTickets = listOf(lotto)
    private val money = Money(5000)

    @Nested
    @DisplayName("당첨 개수")
    inner class WinningCounts {
        /**
         * 당첨 개수 테스트 클래스
         *
         * 당첨 기준별 순서대로, 당첨된 로또의 개수 정보가 담긴 WinningResult 클래스의 winningCounts 를 테스트한다.
         */
        @Test
        @DisplayName("3개 당첨")
        fun `당첨 번호와 숫자가 3개 동일할 때 winningCounts 의 첫 번째 값이 1`() {
            val winningNumbers = listOf(1,2,3,7,8,9)
            val bonusNumber = 10
            val winning = Winning(winningNumbers, bonusNumber)
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.winningCounts[0] == 1)
        }

        @Test
        @DisplayName("4개 당첨")
        fun `당첨 번호와 숫자가 4개 동일할 때 winningCounts 의 두 번째 값이 1`() {
            val winningNumbers = listOf(1,2,3,4,8,9)
            val bonusNumber = 10
            val winning = Winning(winningNumbers, bonusNumber)
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.winningCounts[1] == 1)
        }

        @Test
        @DisplayName("5개 당첨 및 보너스 불일치")
        fun `당첨 번호와 숫자가 5개 동일하고 보너스 번호는 일치하지 않을 때 winningCounts 의 세 번째 값이 1`() {
            val winningNumbers = listOf(1,2,3,4,5,9)
            val bonusNumber = 10
            val winning = Winning(winningNumbers, bonusNumber)
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.winningCounts[2] == 1)
        }

        @Test
        @DisplayName("5개 당첨 및 보너스 일치")
        fun `당첨 번호와 숫자가 5개 동일하고 보너스 번호도 일치할 때 winningCounts 의 네 번째 값이 1`() {
            val winningNumbers = listOf(1,2,3,4,5,9)
            val bonusNumber = 6
            val winning = Winning(winningNumbers, bonusNumber)
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.winningCounts[3] == 1)
        }

        @Test
        @DisplayName("6개 당첨")
        fun `당첨 번호와 숫자가 6개 동일할 때 winningCounts 의 다섯 번째 값이 1`() {
            val winningNumbers = listOf(1,2,3,4,5,6)
            val bonusNumber = 7
            val winning = Winning(winningNumbers, bonusNumber)
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.winningCounts[4] == 1)
        }
    }

    @Nested
    @DisplayName("수익률")
    inner class Margin {
        private val winningNumbers = listOf(1,2,3,7,8,9)
        private val bonusNumber = 10
        private val winning = Winning(winningNumbers, bonusNumber)

        @Test
        @DisplayName("100%")
        fun `구입 금액과 당첨 수익이 동일할 때 수익률 100%`() {
            val winningResult = winningResultGenerator.get(lotteryTickets, winning, money)

            assert(winningResult.margin == 1.0)
        }
    }
}