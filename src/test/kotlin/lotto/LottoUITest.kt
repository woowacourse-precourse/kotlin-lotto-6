package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoUITest {

    @Test
    fun `구입 금액 입력 에러 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("abc")
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("1001")
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("0")
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("-1")
        }
        LottoUI().checkInvalidBuyPrice("1000")
    }

    @Test
    fun `당첨 번호 입력 에러 발생 테스트`() {
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidWinningNumbers("a,b,c,d,5,6".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidWinningNumbers("100,2,3,4,50,60".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidWinningNumbers("1,2,3,4,5".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidWinningNumbers("1,2,3,4,5,6,7".split(","))
        }
        assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidWinningNumbers("1,2,6,4,5,6".split(","))
        }
        LottoUI().checkInvalidWinningNumbers("1,2,3,4,5,6".split(","))
    }
}