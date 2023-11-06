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
            Lotto(setOf(1, 2, 3, 4, 5, 5).toList())
        }
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    fun `구입금액에 정수가 아닌 것을 넣으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkMoney("a4000")
        }
    }

    @Test
    fun `구입금액이 천으로 나누어 떨어지지 않으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkMoney("1300")
        }
    }

    @Test
    fun `구입금액이 천원 이상이 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkMoney("0")
        }
    }

    @Test
    fun `당첨번호가 6자리가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumbersFirst(setOf("1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `당첨번호가 겹치는게 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumbersFirst(setOf("1", "2", "3", "4", "5", "5"))
        }
    }

    @Test
    fun `당첨번호가 정수로 되어있지 않은게 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumbersFirst(setOf("a", "1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `당첨번호가 1에서 45까지의 사이가 아닌게 있다면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkNumbersFirst(setOf("0", "1", "2", "3", "4", "5"))
        }
    }

    @Test
    fun `보너스 번호가 정수가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkBonusNumber("a")
        }
    }

    @Test
    fun `보너스 번호가 1에서 45까지의 사이가 아니라면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            checkBonusNumber("46")
        }
    }
}
