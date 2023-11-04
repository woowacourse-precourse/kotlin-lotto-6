package lotto

import lotto.Controller.LottoManager
import lotto.validate.Validate
import lotto.view.InputView
import lotto.view.OutputView
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
    fun `구입금액에 따라 티켓이 변경되는지 확인한다`() {
        val Manager = LottoManager(InputView(), OutputView())
            Manager.calculateTicket(1000).equals(1)
    }

    @Test
    fun `구입금액이 1000원이 안되는 경우`() {
        val validate = Validate()
        assertThrows<IllegalArgumentException> {
            validate.validateInputPrice("990")
        }
    }

    @Test
    fun `구입금액 입력이 숫자가 아닌경우`() {
        val validate = Validate()
        assertThrows<IllegalArgumentException> {
            validate.validateInputPrice("wooteco")
        }
    }

    @Test
    fun `구입금액 입력이 없는 경우`() {
        val validate = Validate()
        assertThrows<IllegalArgumentException> {
            validate.validateInputPrice("")
        }
    }

    @Test
    fun `구입금액 입력이 1000원으로 안나눠지는 수일 경우`() {
        val validate = Validate()
        assertThrows<IllegalArgumentException> {
            validate.validateInputPrice("1111")
        }
    }
}
