package lotto

import lotto.controller.LottoController
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoController = LottoController()

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `로또 구매 개수`() {
        val purchaseAmount = 8000

        val numberOfPurchase = lottoController.getNumberOfPurchase(purchaseAmount)

        assertThat(numberOfPurchase).isEqualTo(8)
    }
}
