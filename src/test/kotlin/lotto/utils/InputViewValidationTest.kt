package lotto.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputViewValidationTest {

    @Test
    fun `사용자로부터 입력받은 금액이 문자열 형태인 경우 예외 발생`() {
        val amount = "금액"
        assertThrows<IllegalArgumentException> {
            InputViewValidation.validateUserAmount(amount)
        }
    }

    @Test
    fun `사용자로부터 입력받은 금액이 0 이하인 경우 예외 발생`() {
        val amount = "0"
        assertThrows<IllegalArgumentException> {
            InputViewValidation.validateUserAmount(amount)
        }
    }

    @Test
    fun `사용자로부터 입력받은 금액이 1,000으로 나누어 떨어지지 않는 경우 예외 발생`() {
        val amount = "1010"
        assertThrows<IllegalArgumentException> {
            InputViewValidation.validateUserAmount(amount)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호가 겹치지 않는 6개로 정상적`() {
        val numbers = listOf("1","2","3","4","5","6")
        assertDoesNotThrow {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호가 6개가 아닌 경우 예외 발생`() {
        val numbers = listOf("1","2","3","4","5")
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호 중 1 ~ 45가 아닌 숫자가 있는 경우 예외 발생`() {
        val numbers = listOf("1", "-12", "3", "4", "5", "6")
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호 6개 중 겹치는 번호가 존재하는 경우 예외 발생`() {
        val numbers = listOf("1","1","3","4","5","6")
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호 중 문자열이 포함되어 있는 경우 예외 발생`() {
        val numbers = listOf("kkm","2","3","4","5","6")
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 당첨번호 중 소수가 포함되어 있는 경우 예외 발생`() {
        val numbers = listOf("1.1","2","3","4","5","6")
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedNumbersList(numbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 보너스 번호가 유효한 경우`() {
        val bonusNumber = "45"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow {
            InputViewValidation.getValidatedBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 보너스 번호가 문자열 형태인 경우 예외 발생`() {
        val bonusNumber = "k"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 보너스 번호가 허용 범위를 벗어난 경우 예외 발생`() {
        val bonusNumber = "46"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `사용자로부터 입력받은 보너스 번호가 이미 당첨번호에 존재하는 경우 예외 발생`() {
        val bonusNumber = "1"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            InputViewValidation.getValidatedBonusNumber(bonusNumber, winningNumbers)
        }
    }
}