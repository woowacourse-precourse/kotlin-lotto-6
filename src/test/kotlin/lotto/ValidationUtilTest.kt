package lotto

import lotto.util.ValidationUtil
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidationUtilTest {
    @Test
    fun `결제금액 입력시 제대로 값을 입력했는지 확인하는 checkPurchaseAmount 테스트`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("") // 비어 있는 문자열
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("abc") // 숫자 아닌 문자열
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("500") // 1000의 배수가 아닌 금액
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkPurchaseAmount("153135") // 1000의 배수가 아닌 금액
        }

        ValidationUtil.checkPurchaseAmount("1000") // 유효한 금액
    }

    @Test
    fun `당첨번호 입력시 제대로 값을 입력했는지 확인하는 checkWinningNumbers 테스트`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("") // 비어 있는 문자열
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3") // 부족한 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,4,5,6,7") // 너무 많은 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,4,4,5") // 중복 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,85,5,6") // 범위를 벗어난 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("1,2,3,a,5,6") // 숫자가 아닌경우
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkWinningNumbers("aaa") // 이상한 입력값
        }

        ValidationUtil.checkWinningNumbers("1,2,3,4,5,6") // 유효한 번호
    }

    @Test
    fun `보너스번호 입력시 제대로 값을 입력했는지 확인하는 checkBonusNumber 테스트`() {
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("", winningNumbers) // 빈 문자열
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("abc", winningNumbers) // 숫자 아닌 문자열
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("0", winningNumbers) // 범위를 벗어난 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("10000", winningNumbers) // 범위를 벗어난 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkBonusNumber("4", winningNumbers) // 당첨 번호와 중복
        }

        ValidationUtil.checkBonusNumber("7", winningNumbers) // 유효한 보너스 번호
    }

    @Test
    fun `랜덤으로 생성하는 로또번호가 올바른지 체크`() {
        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkLottoNumbers(emptyList()) // 빈 리스트
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkLottoNumbers(listOf(1, 2, 3)) // 부족한 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkLottoNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) // 너무 많은 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkLottoNumbers(listOf(1, 2, 2, 4, 5, 6)) // 중복 숫자
        }

        assertThrows<IllegalArgumentException> {
            ValidationUtil.checkLottoNumbers(listOf(1, 2, 3, 0, 5, 6)) // 범위를 벗어난 숫자
        }

        ValidationUtil.checkLottoNumbers(listOf(1, 2, 3, 4, 5, 6)) // 유효한 번호
    }
}