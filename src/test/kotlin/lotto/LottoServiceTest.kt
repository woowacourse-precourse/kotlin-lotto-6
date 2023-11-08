package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoServiceTest {

    @Test
    fun `구입 개수에 맞게 로또 발행`() {
        var lotto = LottoService().buyLotto(3)
        assertEquals(3, lotto.size)
        lotto = LottoService().buyLotto(5)
        assertEquals(5, lotto.size)
    }
}