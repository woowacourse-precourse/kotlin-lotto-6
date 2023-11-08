package lotto

import lotto.enums.BonusNumberInput
import lotto.enums.AmountInputType
import lotto.enums.WinningNumbersInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoUserInputTest {

    @Test
    fun `숫자가 아닌 문자열을 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkAmountInput("input")).isEqualTo(AmountInputType.NOT_INTEGER)
    }

    @Test
    fun `양수가 아닌 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkAmountInput("0")).isEqualTo(AmountInputType.NOT_POSITIVE)
        assertThat(LottoUserInput.checkAmountInput("-100")).isEqualTo(AmountInputType.NOT_POSITIVE)
    }
    @Test
    fun `1000의 배수가 아닌 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkAmountInput("190")).isEqualTo(AmountInputType.NOT_MULTIPLE_OF_1000)
        assertThat(LottoUserInput.checkAmountInput("2137")).isEqualTo(AmountInputType.NOT_MULTIPLE_OF_1000)
    }

    @Test
    fun `모든 조건을 만족하는 수를 가격으로 입력했을 때`() {
        assertThat(LottoUserInput.checkAmountInput("5000")).isEqualTo(AmountInputType.VALID)
        assertThat(LottoUserInput.checkAmountInput("13000")).isEqualTo(AmountInputType.VALID)
        assertThat(LottoUserInput.checkAmountInput("770000")).isEqualTo(AmountInputType.VALID)
    }

    @Test
    fun `당첨 번호 입력 테스트`() {
        assertThat(LottoUserInput.checkWinningNumbersInput("1,2,3,4,5,6"))
            .isEqualTo(WinningNumbersInput.VALID)
        assertThat(LottoUserInput.checkWinningNumbersInput("1,2,3,4,5"))
            .isEqualTo(WinningNumbersInput.NUMBERS_COUNT_WRONG)
        assertThat(LottoUserInput.checkWinningNumbersInput("1,2,3,4,5,5"))
            .isEqualTo(WinningNumbersInput.NUMBERS_COUNT_WRONG)
        assertThat(LottoUserInput.checkWinningNumbersInput("1,2,3,4,5,60"))
            .isEqualTo(WinningNumbersInput.OUT_OF_LOTTO_RANGE)
        assertThat(LottoUserInput.checkWinningNumbersInput("1,2,3,4,5,a"))
            .isEqualTo(WinningNumbersInput.NOT_ALL_NUMBERS)
    }

    @Test
    fun `보너스 번호가 숫자가 아닌 경우 확인`() {
        assertThat(LottoUserInput.checkBonusNumberInput("abc", listOf()))
            .isEqualTo(BonusNumberInput.NOT_INTEGER)
    }

    @Test
    fun `보너스 번호가 로또 번호 범위를 넘어가는 경우 확인`() {
        assertThat(LottoUserInput.checkBonusNumberInput("70", (1..6).toList()))
            .isEqualTo(BonusNumberInput.OUT_OF_RANGE)
        assertThat(LottoUserInput.checkBonusNumberInput("0", (1..6).toList()))
            .isEqualTo(BonusNumberInput.OUT_OF_RANGE)
        assertThat(LottoUserInput.checkBonusNumberInput("-10", (1..6).toList()))
            .isEqualTo(BonusNumberInput.OUT_OF_RANGE)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되는 경우 확인`() {
        assertThat(LottoUserInput.checkBonusNumberInput("5", (1..6).toList()))
            .isEqualTo(BonusNumberInput.WINNING_NUMBERS_DUPLICATE)
    }

    @Test
    fun `보너스 번호가 올바른 입력인 경우 확인`() {
        assertThat(LottoUserInput.checkBonusNumberInput("10", (1..6).toList()))
            .isEqualTo(BonusNumberInput.VALID)
    }

}