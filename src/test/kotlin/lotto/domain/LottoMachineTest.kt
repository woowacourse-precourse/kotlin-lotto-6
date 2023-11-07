package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `구입금액에 따라 로또를 생성한다`() {
        val lottoMachine = LottoMachine(5000)
        val lottos = lottoMachine.issueLottos()
        val expectedLottosSize = 5
        assertThat(expectedLottosSize).isEqualTo(lottos.size)
    }

    @Test
    fun `pickUniqueNumbersInRange 메서드 테스트`() {
        repeat(10000) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            val numbersSet = numbers.toSet()
            assertThat(numbers).hasSize(6)
            assertThat(numbers.size).isEqualTo(numbersSet.size)
            assertThat(numbers).allMatch { number ->
                number in 1..45
            }
        }
    }

    @Test
    fun `로또와 당첨 로또를 비교하여 결과를 생성한다`() {
        val inputMoney = 10000
        val lottoMachine = LottoMachine(inputMoney)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(2, 3, 4, 5, 6, 7)),
            Lotto(listOf(2, 3, 4, 5, 6, 8)),
            Lotto(listOf(3, 4, 5, 6, 7, 8)),
            Lotto(listOf(4, 5, 6, 8, 9, 10)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val result = lottoMachine.calculateResult(lottos, winningLotto)

        val expectedRankCounts = Rank.entries.map { rank ->
            result.getCount(rank)
        }
        assertThat(expectedRankCounts).allMatch { it == 1}
    }

    @Test
    fun `결과를 통해 수익률을 계산한다 - 아무런 수익이 없는 경우`() {
        val inputMoney = 10000
        val lottoMachine = LottoMachine(inputMoney)
        val result = LottoResult()

        val expectedRateOfReturn = 0.0
        assertThat(expectedRateOfReturn).isEqualTo(lottoMachine.getRateOfReturn(result))
    }

    @Test
    fun `결과를 통해 수익률을 계산한다 - 수익이 있는 경우`() {
        val inputMoney = 8000
        val lottoMachine = LottoMachine(inputMoney)
        val result = LottoResult()
        result.addCount(Rank.FIFTH)

        val expectedRateOfReturn = 62.5
        assertThat(expectedRateOfReturn).isEqualTo(lottoMachine.getRateOfReturn(result))
    }
}