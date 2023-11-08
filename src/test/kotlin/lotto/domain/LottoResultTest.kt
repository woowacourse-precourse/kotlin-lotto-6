package lotto.domain

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class LottoResultTest {
    private val winningNumberSet = Pair(listOf(1, 2, 3, 4, 5, 6), 7)

    companion object {
        @JvmStatic
        fun lottoDataProvider(): List<Pair<List<Lotto>, Map<LottoRank, Int>>> = listOf(
            Pair(
                listOf(Lotto(listOf(1, 2, 3, 4, 5, 6))),
                mapOf(LottoRank.FIRST_PLACE to 1)
            ),
            Pair(
                listOf(Lotto(listOf(1, 2, 3, 4, 5, 7))),
                mapOf(LottoRank.SECOND_PLACE to 1)
            ),
            Pair(
                listOf(
                    Lotto(listOf(1, 2, 3, 14, 5, 7)),
                    Lotto(listOf(1, 2, 3, 4, 5, 13)),
                    Lotto(listOf(1, 2, 3, 7, 12, 45))
                ),
                mapOf(LottoRank.FOURTH_PLACE to 1, LottoRank.THIRD_PLACE to 1, LottoRank.FIFTH_PLACE to 1)
            ),
            Pair(
                listOf(
                    Lotto(listOf(1, 2, 3, 14, 5, 7)), Lotto(listOf(1, 2, 3, 14, 6, 7))
                ),
                mapOf(LottoRank.FOURTH_PLACE to 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("lottoDataProvider")
    fun `구매한 로또들의 결과를 계산하는 기능 테스트`(testData: Pair<List<Lotto>, Map<LottoRank, Int>>) {
        val (lottos, expectedResults) = testData
        val lottoResult = LottoResult(lottos, winningNumberSet)

        expectedResults.forEach { (rank, count) ->
            assertEquals(count, lottoResult.resultLottos[rank])
        }
    }

    @ParameterizedTest
    @CsvSource(
        "10_000, 0, 0.0",
        "10_000, 5_000, 50.0",
        "10_000, 50_000, 500.0",
        "10_000, 1_500_000, 15000.0",
        "10_000, 30_000_000, 300000.0",
        "10_000, 2_000_000_000, 20000000.0"
    )
    fun `수익률 계산 테스트`(
        cost: Int,
        prize: Int,
        expectedProfit: Double
    ) {
        val lottoResult = LottoResult(emptyList(), winningNumberSet)
        lottoResult.totalPrize = prize.toLong()
        val profit = lottoResult.computeProfit(cost)
        assertEquals(expectedProfit, profit)
    }
}