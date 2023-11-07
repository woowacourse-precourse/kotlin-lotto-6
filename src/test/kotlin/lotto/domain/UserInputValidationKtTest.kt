package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInputValidationKtTest {

    companion object {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `구매 금액이 Int가 아니면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "string".purchaseAmountValidation()
        }
    }

    @Test
    fun `구매 금액이 1000 미만이면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "999".purchaseAmountValidation()
            "0".purchaseAmountValidation()
            "-1".purchaseAmountValidation()
        }
    }

    @Test
    fun `구매 금액이 1000으로 나누어 떨어지지 않으면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "0".purchaseAmountValidation()
        }
    }

    @Test
    fun `보너스 번호가 Int가 아니면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "보너스".bonusValidation(winningNumbers)
        }
    }

    @Test
    fun `보너스 번호가 1 ~ 45가 아니면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "1".bonusValidation(winningNumbers)
        }
    }

    @Test
    fun `보너스 번호가 당첨 번호이면 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            "1".bonusValidation(winningNumbers)
        }
    }
}