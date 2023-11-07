package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `1등 테스트 - 6개 매칭`() {
        assertThat(LottoResult.of(6, true)).isEqualTo(LottoResult.SIX_MATCH)
        assertThat(LottoResult.of(6, false)).isEqualTo(LottoResult.SIX_MATCH)
    }

    @Test
    fun `2등 테스트 - 5개 매칭 & 보너스 매칭`() {
        assertThat(LottoResult.of(5, true)).isEqualTo(LottoResult.FIVE_MATCH_WITH_BONUS)
        assertThat(LottoResult.of(5, true)).isNotEqualTo(LottoResult.FIVE_MATCH)
    }

    @Test
    fun `3등 테스트 - 5개 매칭`() {
        assertThat(LottoResult.of(5, false)).isEqualTo(LottoResult.FIVE_MATCH)
        assertThat(LottoResult.of(5, false)).isNotEqualTo(LottoResult.FIVE_MATCH_WITH_BONUS)
    }

    @Test
    fun `4등 테스트 - 4개 매칭`() {
        assertThat(LottoResult.of(4, true)).isEqualTo(LottoResult.FOUR_MATCH)
        assertThat(LottoResult.of(4, false)).isEqualTo(LottoResult.FOUR_MATCH)
    }

    @Test
    fun `5등 테스트 - 3개 매칭`() {
        assertThat(LottoResult.of(3, true)).isEqualTo(LottoResult.THREE_MATCH)
        assertThat(LottoResult.of(3, false)).isEqualTo(LottoResult.THREE_MATCH)
    }
}