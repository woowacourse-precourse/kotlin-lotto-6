package lotto

import lotto.model.LottoCalculate
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoCalculateTest {
    @Test
    fun `수익률이 소수점 둘째자리 이상 나올 경우 둘째 자리에서 반올림`() {
        val result = LottoCalculate().formattedCheck(4.5555)
        assertThat(result).isEqualTo("4.6")
    }

    @Test
    fun `수익률이 소수점 길게(지수표기법 E로 되는)되는 경우에도 반올림`() {
        val result = LottoCalculate().formattedCheck(6.6666666666666664E7)
        assertThat(result).isEqualTo("66666666.7")
    }


}