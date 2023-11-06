package lotto

import lotto.utils.validator.LottoWinningNumbersInputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoWinningNumbersValidatorTest {
    @Test
    fun `알파벳 입력`(){
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbersInputValidator.validate(listOf("1c","c"))
        }
    }
    
    @Test
    fun `공백 입력`(){
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbersInputValidator.validate(listOf("12"," "))
        }
    }

    @Test
    fun `1~45 범위 초과`(){
        assertThrows<IllegalArgumentException> {
            LottoWinningNumbersInputValidator.validate(listOf("100","0"))
        }
    }
}