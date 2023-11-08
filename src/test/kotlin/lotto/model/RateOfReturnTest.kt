package lotto.model

import lotto.model.dto.LottoResult
import lotto.util.Match
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RateOfReturnTest {
    val lottoResults = LottoResults()

    @Test
    fun `당첨금이 0원인 경우) 수익률 0,0% 나오는지 확인`() {
        val rateOfReturn = RateOfReturn(lottoResults.result, 10000).get()

        assertThat(rateOfReturn).isEqualTo("0.0%")
    }

    @Test
    fun `7장 구매해서 5천원 당첨된 경우) 소수점 2째자리에서 버리는 Case (71,43 to 71,4)`() {
        lottoResults.update(LottoResult(3, 0))

        val rateOfReturn = RateOfReturn(lottoResults.result, 7000).get()

        assertThat(rateOfReturn).isEqualTo("71.4%")
    }

    @Test
    fun `30장 구매해서 50만원 당첨된 경우) 소수점 2째자리에서 올림하는 Case (1666,66 to 1666,7)`() {
        repeat(10) {
            lottoResults.update(LottoResult(4, 0))
        }

        val rateOfReturn = RateOfReturn(lottoResults.result, 30000).get()

        assertThat(rateOfReturn).isEqualTo("1,666.7%")
    }

    @Test
    fun `10장 구매해서 1등에 당첨된 경우) 단위 구분을 위한 ","가 출력되는지 확인`() {
        lottoResults.update(LottoResult(6, 0))

        val rateOfReturn = RateOfReturn(lottoResults.result, 10000).get()

        assertThat(rateOfReturn).isEqualTo("20,000,000.0%")
    }
}