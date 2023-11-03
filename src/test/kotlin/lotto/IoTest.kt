package lotto

import lotto.exception.ExceptionChecker
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IoTest {
    private lateinit var checker: ExceptionChecker
    @BeforeEach
    fun setUp() {
        checker = ExceptionChecker()
    }
    @Test
    fun `구입 금액 예외 상황 - 숫자가 아닌 입력1`() {

        assertThrows<IllegalArgumentException> {
            checker.checkAmount("난 숫자")
        }
    }
    @Test
    fun `구입 금액 예외 상황 - 숫자가 아닌 입력2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 숫자가 아닌 입력3`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount(" ")
        }
    }
    @Test
    fun `구입 금액 예외 상황 - 숫자가 아닌 입력4`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("\n")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000이하의 숫자1`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("999")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000이하의 숫자2`() {
        assertThrows<java.lang.IllegalArgumentException> {
            checker.checkAmount("0")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000이하의 숫자3`() {
        assertThrows<java.lang.IllegalArgumentException> {
            checker.checkAmount("-1")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000단위가 아닌 수1`() {
        assertThrows<java.lang.IllegalArgumentException> {
            checker.checkAmount("1001")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000단위가 아닌 수2`() {
        assertThrows<java.lang.IllegalArgumentException> {
            checker.checkAmount("19999")
        }
    }
}