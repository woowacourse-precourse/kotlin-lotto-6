package lotto.model

import lotto.model.dto.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoResultsTest {
    @ParameterizedTest
    @ValueSource(strings = ["3, 0", "4, 0", "6, 0"])
    fun `lottoResult를 기준으로 lottoResults 업데이트 수행, winningMatchCount가 3, 4, 6 일 때`(dataPairs: String) {
        val lottoResults = LottoResults()
        val lottoResult = parseLottoResult(dataPairs)

        lottoResults.update(lottoResult)

        val key = lottoResult.winningMatchCount
        val actual = lottoResults.result.getValue(key)
        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5, 0", "5, 1"])
    fun `lottoResult를 기준으로 lottoResults 업데이트 수행, winningMatchCount가 5 일 때`(dataPairs: String) {
        val lottoResults = LottoResults()
        val lottoResult = parseLottoResult(dataPairs)

        lottoResults.update(lottoResult)

        val key = lottoResult.winningMatchCount * 10 + lottoResult.bonusMatchCount
        val actual = lottoResults.result.getValue(key)
        assertThat(actual).isEqualTo(1)
    }

    companion object {
        fun parseLottoResult(input: String): LottoResult {
            val (winningMatchCount, bonusMatchCount) = input.split(", ").map { it.toInt() }
            return LottoResult(winningMatchCount, bonusMatchCount)
        }
    }
}