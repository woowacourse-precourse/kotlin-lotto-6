package lotto

import lotto.model.LottoPrize
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoPrizeTest {
    @Test
    fun `1등 당첨 확인`() {
        val result = LottoPrize.getLottoPrize(6, false)
        Assertions.assertThat(result).isEqualTo(
            LottoPrize.FIRST
        )
    }

    @Test
    fun `2등 당첨 확인`() {
        val result = LottoPrize.getLottoPrize(5, true)
        Assertions.assertThat(result).isEqualTo(
            LottoPrize.SECOND
        )
    }

    @Test
    fun `3등 당첨 확인`() {
        val result = LottoPrize.getLottoPrize(5, false)
        Assertions.assertThat(result).isEqualTo(
            LottoPrize.THIRD
        )
    }

    @Test
    fun `4등 당첨 확인`() {
        val result = LottoPrize.getLottoPrize(4, false)
        Assertions.assertThat(result).isEqualTo(
            LottoPrize.FOURTH
        )
    }

    @Test
    fun `5등 당첨 확인`() {
        val result = LottoPrize.getLottoPrize(3, false)
        Assertions.assertThat(result).isEqualTo(
            LottoPrize.FIFTH
        )
    }

    @Test
    fun `당첨 안됨`() {
        val result = LottoPrize.getLottoPrize(2, false)
        Assertions.assertThat(result).isEqualTo(LottoPrize.NOTTING)
    }

}