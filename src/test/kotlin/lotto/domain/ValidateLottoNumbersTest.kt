package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import org.junit.jupiter.api.assertThrows

class ValidateLottoNumbersTest {
    private val validateLottoNumbersTest = ValidateLottoNumbers()

    @Test
    @DisplayName("입력받은 당첨 로또 번호에 빈칸이 포함된 경우 ")
    fun validateWinningNumbersContainsEmpty() {
        val input = listOf("1", " ", "2", "3", "4", "5")
        assertThrows<IllegalArgumentException> {
            validateLottoNumbersTest.validateWinningNumbersContainsEmpty(input)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력받은 당첨 로또 번호에 문자가 포함된 경우 ")
    fun validateWinningNumbersString() {
        val input = listOf("1", " ", "2", "3", "4", "j")
        assertThrows<IllegalArgumentException> {
            validateLottoNumbersTest.validateWinningNumbersString(input)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력받은 당첨 로또 번호에 1 ~ 45 사이 숫자가 아닌 숫자가 포함된 경우")
    fun validateWinningNumberInRange() {
        val input = listOf(1,2,3,4,5,46)
        assertThrows<IllegalArgumentException> {
            validateLottoNumbersTest.validateWinningNumberInRange(input)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력받은 당첨 로또 번호에 중복되는 숫자가 있는 경우")
    fun validateWinningNumberDuplicateNumber() {
        val input = listOf(1,2,3,4,5,5)
        assertThrows<IllegalArgumentException> {
            validateLottoNumbersTest.validateWinningNumberDuplicateNumber(input)
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("입력받은 당첨 로또 번호 ,로 나누기 ")
    fun validateWinningNumbersSplitInComma() {
        val input = "1,2,3,4,5,6"
        assertThat(validateLottoNumbersTest.validateWinningNumbers(input))
            .isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("보너스 번호 입력을 하지 않은 경우")
    fun validateBonusNumberContainsEmpty() {
        val input = "\n"
        assertThrows<IllegalArgumentException> {
            assertThat(validateLottoNumbersTest.validateBonusNumberContainsEmpty(input))
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("보너스 번호에 문자가 포함된 경우")
    fun validateBonusNumberString() {
        val input = "1d"
        assertThrows<IllegalArgumentException> {
            assertThat(validateLottoNumbersTest.validateBonusNumberString(input))
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이 숫자가 아닌 경우")
    fun validateBonusNumberInRange() {
        val input = 46
        assertThrows<IllegalArgumentException> {
            assertThat(validateLottoNumbersTest.validateBonusNumberInRange(input))
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 이미 존재하는 경우")
    fun validateBonusNumberInWinningNumbers() {
        val bonusNumber = 3
        val winningNumbers = listOf(1,2,3,4,5,6)

        assertThrows<IllegalArgumentException> {
            assertThat(validateLottoNumbersTest.validateBonusNumberInWinningNumbers(bonusNumber, winningNumbers))
        }.also { exception ->
            assertThat(exception.message).contains(ERROR_MESSAGE)
        }
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}