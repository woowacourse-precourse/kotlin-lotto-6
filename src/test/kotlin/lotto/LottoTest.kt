package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `입력한 보너스 로또 넘버가 이전 로또 넘버와 중복일 경우 예외`() {
        assertThrows<IllegalArgumentException> {
            val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
            ExceptionHandler.checkBonusNumber("6", numberList)
        }
    }

    @Test
    fun `로또 번호의 개수가 6개 미만이라면 예외`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `금액이 1000원으로 나누어떨어지는지 예외`() {
        assertThrows<IllegalArgumentException> {
            val money = " 2244"
            ExceptionHandler.checkInputMoney(money)
        }
    }

    @Test
    fun `금액이 숫자로 이루어져있는지 예외`() {
        assertThrows<IllegalArgumentException> {
            val money = "ab12"
            ExceptionHandler.checkInputMoney(money)
        }
    }

    @Test
    fun `금액에 음수값 입력 예외`() {
        assertThrows<IllegalArgumentException> {
            val money = "-2000"
            ExceptionHandler.checkInputMoney(money)
        }
    }

    @Test
    fun `로또 번호에 숫자가 아닌 입력에 대한 예외`() {
        assertThrows<IllegalArgumentException> {
            val numbers = "1,2,3,4,5,a"
            ExceptionHandler.checkWinningNumber(numbers)
        }
    }

    @Test
    fun `보너스 번호에 숫자가 아닌 입력에 대한 예외`() {
        assertThrows<IllegalArgumentException> {
            val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
            ExceptionHandler.checkBonusNumber("abc", numberList)
        }
    }

    @Test
    fun `로또 번호에 1 미만 45 초과 숫자 입력에 대한 예외`() {
        assertThrows<IllegalArgumentException> {
            val numbers = "0,1,2,3,4,5"
            ExceptionHandler.checkWinningNumber(numbers)
        }
    }

    @Test
    fun `보너스 번호에 1 미만 45 초과 숫자 입력에 대한 예외`() {
        assertThrows<IllegalArgumentException> {
            val numberList = listOf<Int>(1, 2, 3, 4, 5, 6)
            ExceptionHandler.checkBonusNumber("46", numberList)
        }
    }

}
