package lotto

import lotto.user.LottoPurchase
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {
    @Test
    fun `숫자가 아닌 값이 구입 금액으로 들어오면 에러 발생`(){
        assertThrows<IllegalArgumentException> {
            LottoPurchase().validatePurchase("abcde")
        }
    }
    @Test
    fun `숫자와 문자열이 구입 금액으로 들어오면 에러 발생`(){
        assertThrows<IllegalArgumentException>{
            LottoPurchase().validatePurchase("5000a")
        }
    }
    @Test
    fun `숫자만 들어왔을 경우에는 바로 통과`(){
        val validator = LottoPurchase()
        assertTrue(validator.validatePurchase("4000"))
    }
    @Test
    fun `1000원 단위로 안 나누어 떨어지는 구입 금액이면 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchase().validatePurchase("4500")
        }
    }
}