package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionManagerTest {
    private val exceptionManager = ExceptionManager()

    @Test
    fun `알맞은 값을 입력 하였을 때 정상실행`() {
        exceptionManager.moneyException("2000")
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-1000"])
    fun `음수를 입력 하였을 때 예외처리`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.moneyException(input)
        }
        assert(exception.message == ErrorMessage.INPUT_NOT_MINUS.msg)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1230", "1001"])
    fun `천 단위로 입력하지 않았을 때 예외처리`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.moneyException(input)
        }
        assert(exception.message == ErrorMessage.INPUT_THOUSAND.msg)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000000", "150000"])
    fun `최대 구매 금액을 넘었을 때 예외처리`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.moneyException(input)
        }

        assertEquals(exception.message, ErrorMessage.MAX_PURCHASE_PRIZE.msg)
    }

    @Test
    fun `알맞은 값을 넣었을 때 테스트`() {
        val numbers = listOf("1", "2", "3", "4", "5", "6")
        exceptionManager.winningNumberException(numbers)
    }

    @Test
    fun `숫자가 아닌 문자열을 넣었을 때 예외처리`() {
        val numbers = listOf("1", "2", "3", "4", "5", "6a")
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.winningNumberException(numbers)
        }
        assert(exception.message == ErrorMessage.NOT_STRING.msg)
    }

    @Test
    fun `1~45 사이의 범위가 아닌 숫자 예외처리`() {
        val numbers = listOf("0", "46", "3", "4", "5", "6")
        // 숫자가 1부터 45 사이가 아닌 경우에 대한 테스트
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.winningNumberException(numbers)
        }
        assert(exception.message == ErrorMessage.NOT_RANGE.msg)
    }
    @Test
    fun `값에 중복이 있을 경우 예외처리`() {
        val numbers = listOf("1", "2", "3", "4", "4", "5")
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.winningNumberException(numbers)
        }
        assert(exception.message == ErrorMessage.NOT_DUPLICATE.msg)
    }
    @Test
    fun `숫자가 6개가 아닌 경우 예외처리`() {
        val numbers = listOf("1", "2", "3", "4", "5")
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.winningNumberException(numbers)
        }
        assert(exception.message == ErrorMessage.NOT_SIX.msg)
    }

    @Test
    fun `알맞은 값 입력시 테스트`() {
        val numbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = "7"
        exceptionManager.bonusNumberException(Pair(numbers, bonusNumber))
    }

    @Test
    fun `보너스 숫자가 당첨번호에 있는경우 예외처리`() {
        val numbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = "6"
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.bonusNumberException(Pair(numbers, bonusNumber))
        }
        assert(exception.message == ErrorMessage.NOT_IN_NUMBERS.msg)
    }

    @Test
    fun `보너스 숫자가 범위에 벗어나는 경우 예외처리`() {
        val numbers = listOf("1", "2", "3", "4", "5", "6")
        val bonusNumber = "46"
        val exception = assertThrows<IllegalArgumentException> {
            exceptionManager.bonusNumberException(Pair(numbers, bonusNumber))
        }
        assert(exception.message == ErrorMessage.NOT_RANGE.msg)
    }

}