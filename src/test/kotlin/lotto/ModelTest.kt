package lotto

import lotto.model.Prize
import lotto.model.Purchase
import lotto.model.Results
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class ModelTest {
    @Test
    fun `로또 수익률 검사`() {
        val prize = Prize(listOf(0,0,0,0,1), 1000)
        assertThat(prize.rate).isEqualTo("500.0")
    }

    @Test
    fun `로또의 개수가 올바르게 구해지는지 테스트`() {
        val purchase = Purchase(8000)
        assertThat(purchase.count).isEqualTo(8)
    }

    @Test
    fun `로또 번호와 당첨 번호의 비교가 제대로 이루어지는지 테스트`() {
        val result = Results(listOf(1,2,3,4,5,6),7)
        val count = result.calculateRanking(listOf(1,2,3,4,5,6))
        assertThat(count).isEqualTo(0)
    }
}