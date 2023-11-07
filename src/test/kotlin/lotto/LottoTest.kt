package lotto

import lotto.domain.LottoPurchase
import lotto.model.Lotto
import lotto.validate.ValidateNumbers
import lotto.validate.ValidatePrice
import lotto.validate.ValidateSplit
import lotto.validate.ValidateBonus
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
        val lottoPurchase = LottoPurchase()
            lottoPurchase.calculateTicket(1000)
    }

    @Test
    fun `구입금액이 1000원이 안되는 경우`() {
        val validatePrice = ValidatePrice()
        assertThrows<IllegalArgumentException> {
            validatePrice.validateInputPrice("990")
        }
    }

    @Test
    fun `구입금액 입력이 숫자가 아닌경우`() {
        val validatePrice = ValidatePrice()
        assertThrows<IllegalArgumentException> {
            validatePrice.validateInputPrice("wooteco")
        }
    }

    @Test
    fun `당첨 번호에서 쉼표가 없는경우`() {
        val validate = ValidateNumbers()
        assertThrows<IllegalArgumentException> {
            validate.validateInputNumbers("1.2.3.4.5.6")
        }
    }

    @Test
    fun `구입금액 입력이 없는 경우`() {
        val validatePrice = ValidatePrice()
        assertThrows<IllegalArgumentException> {
            validatePrice.validateInputPrice("")
        }
    }

    @Test
    fun `구입금액 입력이 1000원으로 안 나눠지는 수일 경우`() {
        val validatePrice = ValidatePrice()
        assertThrows<IllegalArgumentException> {
            validatePrice.validateInputPrice("1111")
        }
    }

    @Test
    fun `당첨번호가 숫자가 아닌 경우`() {
        val validateSplit = ValidateSplit()
        assertThrows<IllegalArgumentException> {
            validateSplit.validateSplitMyNumbers(listOf("wooteco"))
        }
    }

    @Test
    fun `당첨 번호에 공백이 존재할 경우`() {
        val validateSplit = ValidateSplit()
        assertThrows<IllegalArgumentException> {
            validateSplit.validateSplitMyNumbers(listOf(" ","3","7"))
        }
    }

    @Test
    fun `당첨번호가 입력 범위를 벗어난 경우`() {
        val validateSplit = ValidateSplit()
        assertThrows<IllegalArgumentException> {
            validateSplit.validateSplitMyNumbers(listOf("100"))
        }
    }

    @Test
    fun `당첨번호에 중복이 존재할 경우`() {
        val validateSplit = ValidateSplit()
        assertThrows<IllegalArgumentException> {
            validateSplit.validateSplitMyNumbers(listOf("1", "1"))
        }
    }

    @Test
    fun `보너스번호와 당첨번호에 중복이 존재할 경우`() {
        val validateBonus = ValidateBonus()
        val bonusNumber = 1
        assertThrows<IllegalArgumentException> {
            validateBonus.validateBonus(bonusNumber, listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
