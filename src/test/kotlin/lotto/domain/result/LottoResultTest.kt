package lotto.domain.result

import domain.result.LottoResult
import domain.result.Rank
import lotto.constants.Constants.FORMAT_ONE_DECIMAL_PLACE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult
    private lateinit var lotties: List<List<Int>>
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int? = null

    @BeforeEach
    fun setup() {
        lotties = listOf(
            listOf(8, 21, 23, 41, 42, 43), // bonus
            listOf(3, 5, 11, 16, 32, 38),
            listOf(7, 11, 16, 35, 36, 44),
            listOf(1, 8, 11, 31, 41, 42), // bonus
            listOf(13, 14, 16, 38, 42, 45),
            listOf(7, 11, 30, 40, 42, 43),
            listOf(2, 13, 22, 32, 38, 45),
            listOf(1, 3, 5, 14, 22, 45),
        )
        winningNumbers = listOf(1, 15, 26, 33, 35, 42)
        bonusNumber = 8

        lottoResult = LottoResult(lotties, winningNumbers, bonusNumber!!)
    }

    @Test
    fun `보너스 여부 반환 테스트`() {
        val expectedResult = listOf(true, false, false, true, false, false, false, false)

        lotties.zip(expectedResult) { lotto, expected ->
            assertThat(lottoResult.getContainsBonusOrNot(lotto)).isEqualTo(expected)
        }
    }

    @Test
    fun `로또 한 장의 적중 수 테스트`() {
        val expectedResult = listOf(1, 0, 1, 2, 1, 1, 0, 1)

        lotties.zip(expectedResult) { lotto, expected ->
            assertThat(lottoResult.getWinningCount(lotto)).isEqualTo(expected)
        }
    }

    @Test
    fun `구입한 로또에 대한 순위 테스트`() {
        lotties.onEach {
            val actualResult = lottoResult.getResultForEachLotto(it)
            assertThat(actualResult).isEqualTo(null)
        }
    }

    @Test
    fun `구입한 로또에 대한 수익률 테스트`() {
        val resultMap = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 0,
            Rank.THIRD to 2,
            Rank.FOURTH to 1,
            Rank.FIFTH to 2
        )

        assertThat(
            lottoResult.getRateOfReturn(resultMap)
        ).isEqualTo(FORMAT_ONE_DECIMAL_PLACE.format(25038250.0))
    }
}
