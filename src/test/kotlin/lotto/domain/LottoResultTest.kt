package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.roundToInt

class LottoResultTest {
    @Test
    fun `computeGrossProfit 메서드 사용시 초기자본 대비 수익률을 반환`() {
        //given
        val first = 3000
        val last = 4000
        val result = 133.3
        val lottoResult = LottoResult(Lottos(0).getLottoRanks(listOf(0,0,0,0,0,0),0))

        //then
        Assertions.assertThat(
            lottoResult.computeGrossProfit(first,last)).isEqualTo(result)
    }
}