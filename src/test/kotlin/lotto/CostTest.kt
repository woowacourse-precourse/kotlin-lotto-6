package lotto

import lotto.model.Cost
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CostTest {
    @Test
    fun `Cost가 제대로 설정되는지 테스트`() {
        val cost = Cost(10000)

        val result = cost.getLottoCount()
        Assertions.assertThat(result).isEqualTo(10)
    }
}