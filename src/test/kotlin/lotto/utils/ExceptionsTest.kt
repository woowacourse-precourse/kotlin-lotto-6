package lotto.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import lotto.utils.CommonConst
import lotto.utils.Exceptions
import org.assertj.core.api.Assertions.assertThat

class ExceptionsTest {

    @Test
    fun `validatePurchaseAmount 메서드로 구입 금액 유효성 검사`() {

        val validInput = "10000"
        val invalidInput1 = "abc"
        val invalidInput2 = "1500"
        val invalidInput3 = "10001"

        assertThat(Exceptions.validatePurchaseAmount(validInput)).isEqualTo(10000)
        assertThrows<IllegalArgumentException> { Exceptions.validatePurchaseAmount(invalidInput1) }
        assertThrows<IllegalArgumentException> { Exceptions.validatePurchaseAmount(invalidInput2) }
        assertThrows<IllegalArgumentException> { Exceptions.validatePurchaseAmount(invalidInput3) }
    }

    @Test
    fun `validateWinningNumbers 메서드로 당첨 번호 유효성 검사`() {

        val validInput = "1,2,3,4,5,6"
        val invalidInput1 = "1,2,3,4,5"
        val invalidInput2 = "1,2,3,4,5,60"
        val invalidInput3 = "1,2,3,4,5,a"
        val invalidInput4 = "1,2,3,4,5,60"

        assertThat(Exceptions.validateWinningNumbers(validInput)).isEqualTo(validInput)
        assertThrows<IllegalArgumentException> { Exceptions.validateWinningNumbers(invalidInput1) }
        assertThrows<IllegalArgumentException> { Exceptions.validateWinningNumbers(invalidInput2) }
        assertThrows<IllegalArgumentException> { Exceptions.validateWinningNumbers(invalidInput3) }
        assertThrows<IllegalArgumentException> { Exceptions.validateWinningNumbers(invalidInput4) }
    }

    @Test
    fun `validateDuplicates 메서드로 중복 번호 유효성 검사`() {

        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        val invalidNumbers = listOf(1, 1, 2, 3, 4, 5)

        Exceptions.validateDuplicates(validNumbers)
        assertThrows<IllegalArgumentException> { Exceptions.validateDuplicates(invalidNumbers) }
    }

    @Test
    fun `validateBonusNumber 메서드로 보너스 번호 유효성 검사`() {

        val validInput = "7"
        val invalidInput1 = "77"
        val invalidInput2 = "a"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThat(Exceptions.validateBonusNumber(validInput, winningNumbers)).isEqualTo(7)
        assertThrows<IllegalArgumentException> { Exceptions.validateBonusNumber(invalidInput1, winningNumbers) }
        assertThrows<IllegalArgumentException> { Exceptions.validateBonusNumber(invalidInput2, winningNumbers) }
    }
}
