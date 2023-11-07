package lotto.domain

import lotto.domain.model.LottoResult
import lotto.domain.model.Purchase
import lotto.domain.model.Rank
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `로또 수익률 계산 검증`() {
        Assertions.assertThat(
            LottoResult(
                mapOf(Pair(Rank.FOURTH_PLACE, 1)),
            ).calculatePerformance(Purchase(50000)),
        ).isEqualTo(100f)
        Assertions.assertThat(
            LottoResult(
                mapOf(
                    Pair(Rank.FOURTH_PLACE, 1),
                    Pair(Rank.FIFTH_PLACE, 1),
                ),
            ).calculatePerformance(Purchase(50000)),
        ).isEqualTo(110f)
    }
}
