package lotto

import lotto.domain.ExampleLottoGenerator
import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `로또들의 결과 확인`() {
        val result = Lottos(2, ExampleLottoGenerator()).getLottoPrizes(
            Lotto(listOf(8, 21, 23, 41, 42, 43)), 7
        )
        Assertions.assertThat(result).isEqualTo(listOf(LottoPrize.FIRST, LottoPrize.FIRST))
    }

    @Test
    fun `보너스는 당첨됏지만 갯수가 3이 안될 때`() {
        val result = Lottos(1, ExampleLottoGenerator()).getLottoPrizes(
            Lotto(listOf(8, 19, 20, 37, 38, 45)), 21
        )
        Assertions.assertThat(result).isEqualTo(listOf(LottoPrize.NOTTING))
    }

}