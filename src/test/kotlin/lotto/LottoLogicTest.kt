package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoLogicTest {

    @Test
    fun `로또가 주어진 갯수만큼 생성되는지 확인`() {
        val lottoCount = 10
        assertThat(LottoLogic.createLotto(lottoCount))
            .hasSize(lottoCount)
    }

}