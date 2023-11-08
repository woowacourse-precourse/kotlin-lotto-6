package lotto

import org.junit.jupiter.api.Test

class LottoUITest {

    @Test
    fun `구입 금액 입력 에러 발생 테스트`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("abc")
        }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("1001")
        }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("0")
        }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            LottoUI().checkInvalidBuyPrice("-1")
        }
        LottoUI().checkInvalidBuyPrice("1000")
    }
}