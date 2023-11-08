package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoServiceTest {

    @Test
    fun `구입 개수에 맞게 로또 발행`() {
        var lotto = LottoService().buyLotto(3)
        assertEquals(3, lotto.size)
        lotto = LottoService().buyLotto(5)
        assertEquals(5, lotto.size)
    }

    @Test
    fun `구입 금액 입력 에러 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidBuyPrice("abc")
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidBuyPrice("1001")
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidBuyPrice("0")
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidBuyPrice("-1")
        }
        LottoService().checkInvalidBuyPrice("1000")
    }

    @Test
    fun `당첨 번호 입력 에러 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidWinningNumbers("a,b,c,d,5,6".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidWinningNumbers("100,2,3,4,50,60".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidWinningNumbers("1,2,3,4,5".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidWinningNumbers("1,2,3,4,5,6,7".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoService().checkInvalidWinningNumbers("1,2,6,4,5,6".split(","))
        }
        LottoService().checkInvalidWinningNumbers("1,2,3,4,5,6".split(","))
    }
}