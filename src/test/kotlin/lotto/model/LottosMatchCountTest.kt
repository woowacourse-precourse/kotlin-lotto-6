package lotto.model

import lotto.dto.LottoMatchCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosMatchCountTest {
    @ParameterizedTest
    @ValueSource(strings = ["3, 0", "4, 0", "6, 0"])
    fun `lottoResult를 기준으로 lottoResults 업데이트 수행, winningMatchCount가 3, 4, 6 일 때`(dataPairs: String) {
        val lottosMatchCount = LottosMatchCount()
        val lottoResult = parseLottoResult(dataPairs)

        lottosMatchCount.update(lottoResult)

        val key = lottoResult.winning
        val actual = lottosMatchCount.result.getValue(key)
        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5, 0", "5, 1"])
    fun `lottoResult를 기준으로 lottoResults 업데이트 수행, winningMatchCount가 5 일 때`(dataPairs: String) {
        val lottosMatchCount = LottosMatchCount()
        val lottoResult = parseLottoResult(dataPairs)

        lottosMatchCount.update(lottoResult)

        val key = lottoResult.winning * 10 + lottoResult.bonus
        val actual = lottosMatchCount.result.getValue(key)
        assertThat(actual).isEqualTo(1)
    }

    companion object {
        fun parseLottoResult(input: String): LottoMatchCount {
            val (winningMatchCount, bonusMatchCount) = input.split(", ").map { it.toInt() }
            return LottoMatchCount(winningMatchCount, bonusMatchCount)
        }
    }
}