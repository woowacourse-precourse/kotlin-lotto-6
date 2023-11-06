package lotto

import lotto.util.Check
import lotto.util.Check.checkMoney
import lotto.util.Util.getRoi
import lotto.view.Message
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UtilTest {

    @Test
    fun `구매하려는 금액이 숫자가 아닌 값이 들어오면 예외가 발생한다`() {
        val input = "invalid"

        val exception = assertThrows<IllegalArgumentException> {
            requestMoneyForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_INT.message) == true)
    }

    @Test
    fun `구매하려는 금액이 1000의 배수의 숫자가 들어오면 성공`() {
        val input = "8000"
        val expected = 8000

        val result = requestMoneyForTest(input)

        assertEquals(expected, result)

    }

    @Test
    fun `구매하려는 금액이 1000의 배수가 아닌 숫자가 들어오면 예외가 발생한다`() {

        val input = "8001"

        val exception = assertThrows<IllegalArgumentException> {
            requestMoneyForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_PURCHASE_PRICE.message) == true)

    }

    @Test
    fun `당첨번호가 ,를 기준으로 서로다른 6개의 숫자가 아니면 예외가 발생한다`() {
        val input = "1,2,3,4,5,5"

        val exception = assertThrows<IllegalArgumentException> {
            requestWinningNumbersForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_SIX_DIFFERENT_NUMBERS.message) == true)
    }

    @Test
    fun `당첨번호가 ,를 기준으로 숫자가 1~45에 속해있지 않으면 예외가 발생한다`() {
        val input = "1,2,3,4,5,50"

        val exception = assertThrows<IllegalArgumentException> {
            requestWinningNumbersForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_NUMBER_RANGE.message) == true)
    }

    @Test
    fun `당첨번호가 ,를 기준으로 1~45의 서로다른 6개의 숫자가 들어오면 성공`() {
        val input = "1,2,3,4,5,6"
        val expected = listOf(1, 2, 3, 4, 5, 6)

        val result = requestWinningNumbersForTest(input)

        assertEquals(expected, result)
    }

    @Test
    fun `보너스 번호가 1~45까지의 숫자가 아니면 예외 발생`() {
        val input = "50"

        val exception = assertThrows<IllegalArgumentException> {
            requestBonusNumberForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_NUMBER_RANGE.message) == true)
    }

    @Test
    fun `보너스 번호가 숫자가 아니면 예외 발생`() {
        val input = "invalid"

        val exception = assertThrows<IllegalArgumentException> {
            requestBonusNumberForTest(input)
        }

        assertTrue(exception.message?.contains(Message.ERROR_INT.message) == true)

    }

    @Test
    fun `보너스 번호가 1~45까지의 1개의 숫자이면 성공`() {
        val input = "1"
        val expected = 1

        val result = requestBonusNumberForTest(input)

        assertEquals(expected, result)
    }

    @Test
    fun `투자금과 당첨금의 roi는 소수 둘째자리에서 반올림 해야 성공`() {
        val investment = 10000
        val prizeMoney = 8755
        val expected = 87.6

        val result = getRoi(investment, prizeMoney)

        assertEquals(expected, result)

    }


    fun requestMoneyForTest(input: String): Int {
        val purchasePrice = input.toIntOrNull()
        checkMoney(purchasePrice)
        return purchasePrice!!
    }

    fun requestWinningNumbersForTest(input: String): MutableList<Int?> {

        val winningNumbersList = input.replace(" ", "").split(",").map { it.toIntOrNull() }.toMutableList()

        Check.checkWinningNumbers(winningNumbersList)

        return winningNumbersList
    }

    fun requestBonusNumberForTest(input: String): Int {

        val bonusNumber = input.toIntOrNull()

        Check.checkBonusNumber(bonusNumber)

        return bonusNumber!!
    }
}