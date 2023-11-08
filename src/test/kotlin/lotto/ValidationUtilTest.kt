package lotto

import lotto.model.LottoModel
import lotto.util.ValidationUtil
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationUtilTest {
    private val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 값이 맞는 경우`() {
        ValidationUtil.checkPurchaseAmount("1000")
        ValidationUtil.checkPurchaseAmount("1000000")
    }

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 비어 있는 문자열`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("")
        }
    }

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 1000000원 이상일시`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("1000001")
        }
    }

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 숫자 아닌 문자열`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("abc")
        }
    }

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 1000의 배수가 아닌 금액`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("500")
        }
    }

    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트 - 1000의 배수가 아닌 금액 2`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("151515")
        }
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 제대로 입력한 경우`() {
        ValidationUtil.checkWinningNumbers("1,2,3,4,5,6")
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 비어 있는 문자열`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("")
        }
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 부족한 숫자`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3")
        }
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 비어 - 너무 많은 숫자`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 중복된 숫자`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,4,4,5")
        }
    }
    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 범위를 벗어난 숫자`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,85,5,6")
        }
    }
    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,a,5,6")
        }
    }
    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트 - 이상한 입력값`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("aaa")
        }
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 제대로 입력한 경우`() {
        ValidationUtil.checkBonusNumber("7", winningNumbers)
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 빈 문자열`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("", winningNumbers)
        }
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 숫자가 아닐경우`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("abc", winningNumbers)
        }
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 범위를 벗어난 숫자`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("0", winningNumbers)
        }
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 범위를 벗어난 숫자2`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("10000", winningNumbers)
        }
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트 - 당첨 번호와 중복`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("4", winningNumbers)
        }
    }
}