package lotto.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationUtilTest {

    @Test
    fun `구매 금액이 양수가 아닐때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validatePurchaseAmount("-1000")
        }
        assertTrue(exception.message!!.contains("[ERROR] 구매 금액은 양수여야 합니다."))
    }

    @Test
    fun `구매 금액이 숫자가 아닐 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validatePurchaseAmount("삼천원")
        }
        assertTrue(exception.message!!.contains("[ERROR] 유효하지 않은 금액입니다."))
    }

    @Test
    fun `구매 금액이 1000원 단위가 아닐 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validatePurchaseAmount("2500")
        }
        assertTrue(exception.message!!.contains("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다."))
    }

    @Test
    fun `당첨 번호 숫자의 수는 6개여야 함`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateWinningNumbers("1,2,3,4,5,6,6")
        }
        assertTrue(exception.message!!.contains("[ERROR] 당첨 번호는 6개여야 합니다."))
    }

    @Test
    fun `당첨 번호가 1부터 45 사이의 유효한 숫자여야 함`() {
        val outOfRangeWinningNumbers = "1,2,3,4,5,46"
        val outOfRangeException = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateWinningNumbers(outOfRangeWinningNumbers)
        }
        assertTrue(outOfRangeException.message!!.contains("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."))
    }

    @Test
    fun `당첨 번호가 숫자가 아닐 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateWinningNumbers("1,2,3,4,5,오")
        }
        assertTrue(exception.message!!.contains("[ERROR] 유효하지 않은 당첨 번호입니다."))
    }

    @Test
    fun `당첨 번호가 중복될 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateWinningNumbers("1,2,3,3,4,5")
        }
        assertTrue(exception.message!!.contains("[ERROR] 당첨 번호는 중복될 수 없습니다."))
    }

    @Test
    fun `보너스 번호가 숫자가 아닐 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateBonusNumber("보너스", listOf(1, 2, 3, 4, 5, 6))
        }
        assertTrue(exception.message!!.contains("[ERROR] 유효하지 않은 보너스 번호입니다."))
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복될 때 예외 발생`() {
        val exception = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateBonusNumber("1", listOf(1, 2, 3, 4, 5, 6))
        }
        assertTrue(exception.message!!.contains("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."))
    }

    @Test
    fun `보너스 번호가 1부터 45 사이에 있어야 함`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val outOfRangeBonusNumber = "46"
        val outOfRangeException = assertThrows<IllegalArgumentException> {
            ValidationUtil.validateBonusNumber(outOfRangeBonusNumber, winningNumbers)
        }
        assertTrue(outOfRangeException.message!!.contains("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."))
    }
}
