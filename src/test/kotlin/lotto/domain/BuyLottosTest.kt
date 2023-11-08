package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BuyLottosTest {
    private val buyLottos = BuyLottos()
    private val inputBuyLottoCount = 8

    @Test
    @DisplayName("로또 구매 개수와 동일한 크기의 Lotto 리스트 생성 확인")
    fun buyLottos() {
        assertThat(buyLottos.buyLottos(inputBuyLottoCount).size).isEqualTo(inputBuyLottoCount)
    }

}