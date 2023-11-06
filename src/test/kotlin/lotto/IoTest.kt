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
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("0")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000이하의 숫자3`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("-1")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000단위가 아닌 수1`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("1001")
        }
    }

    @Test
    fun `구입 금액 예외 상황 - 1000단위가 아닌 수2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkAmount("19999")
        }
    }

    @Test
    fun `당첨 번호 입력에 숫자가 아닌게 있을 때`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("a","1","2","3","4","5"))
        }
    }
    @Test
    fun`당첨 번호 입력이 6자리가 아닐 때1`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("2","3","4","5"))
        }
    }

    @Test
    fun`당첨 번호 입력이 6자리가 아닐 때2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("1","33","2","3","4","5","6"))
        }
    }
    @Test
    fun `당첨 번호 입력에 중복이 있을 때`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("1","1","2","3","4","5"))
        }
    }
    @Test
    fun`당첨 번호 입력이 범위 밖에 있을 때1`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("46","1","2","3","4","5"))
        }
    }

    @Test
    fun`당첨 번호 입력이 범위 밖에 있을 때2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkWinningNumbers(listOf("0","1","2","3","4","5"))
        }
    }

    @Test
    fun`보너스 번호 입력이 숫자가 아닐 때`() {
        assertThrows<IllegalArgumentException> {
            checker.checkBonusNumber(listOf(1,2,3,4,5,6),"")
        }
    }
    @Test
    fun`보너스 번호 입력이 숫자가 아닐 때2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkBonusNumber(listOf(1,2,3,4,5,6),"a")
        }
    }

    @Test
    fun`보너스 번호 입력이 당첨번호와 중복이 있을 때`() {
        assertThrows<IllegalArgumentException> {
            checker.checkBonusNumber(listOf(1,2,3,4,5,6),"1")
        }
    }

    @Test
    fun`보너스 번호 입력이 범위 밖일 때1`() {
        assertThrows<IllegalArgumentException> {
            checker.checkBonusNumber(listOf(1,2,3,4,5,6),"0")
        }
    }

    @Test
    fun`보너스 번호 입력이 범위 밖일 때2`() {
        assertThrows<IllegalArgumentException> {
            checker.checkBonusNumber(listOf(1,2,3,4,5,6),"46")
        }
    }
}