package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStatusTest {
    val myBuyLotto = LottoStatus()

    @Test
    fun `로또 구매 가격에 문자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            myBuyLotto.validatePrice("1000k")
        }
    }
}