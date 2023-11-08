package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoFactoryTest {
    @Test
    fun `로또 번호 한 줄 생성 테스트`() {
        val createdLottoNum = LottoNumbersFactory().createLottoNumbers()

        assertThat(createdLottoNum.getLottoNumbers()).allMatch { it in 1..45 }
        assertThat(createdLottoNum.getLottoNumbers()).doesNotHaveDuplicates()
        assertThat(createdLottoNum.getLottoNumbers().size).isEqualTo(6)
    }
    @Test
    fun `개수에 따른 자동 로또 번호 생성 테스트`(){
        val createdLottoPaper = LottoPaper(8)
        assertThat(createdLottoPaper.getLottoPaper().size).isEqualTo(8)
        assertThat(createdLottoPaper.getLottoPaper()).allSatisfy {
            assertThat(it.getLottoNumbers()).allMatch { it in 1..45 }
            assertThat(it.getLottoNumbers()).doesNotHaveDuplicates()
            assertThat(it.getLottoNumbers().size).isEqualTo(6)
        }
    }
}