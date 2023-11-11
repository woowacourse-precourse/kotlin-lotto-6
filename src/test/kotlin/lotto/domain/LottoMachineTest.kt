package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = ["5000 : 5", "10000 : 10", "22000 : 22"], delimiter = ':')
    fun `구입금액에 따라 로또를 생성한다`(inputMoney: Int, expectedSize: Int) {
        val lottoMachine = LottoMachine(inputMoney)
        val lottos = lottoMachine.issueLottos()
        assertThat(expectedSize).isEqualTo(lottos.size)

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
            result.getRankCount(rank)
        }
        assertThat(expectedRankCounts).allMatch { it == 1 }
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
        result.updateCount(Rank.FIFTH)

        val expectedRateOfReturn = 62.5
        assertThat(expectedRateOfReturn).isEqualTo(lottoMachine.getRateOfReturn(result))
    }
}