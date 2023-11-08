package lotto

import lotto.utils.validator.LottoWinningNumberInputValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoWinningNumbersValidatorTest {
    private lateinit var lottoWinningNumberInputValidator : LottoWinningNumberInputValidator

    @BeforeEach
    fun `셋팅`(){
        lottoWinningNumberInputValidator = LottoWinningNumberInputValidator()
    }

    @Test
    fun `정상적인 로또 번호 입력`(){
        assert(lottoWinningNumberInputValidator.validate(listOf("1","2","33","44","12","15")))
    }

    fun `로또 번호가 6개 아닐 때`(){
        assert(!lottoWinningNumberInputValidator.validate(listOf("1","2","33","44","12")))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1c","c"," ","~!@~!@"])
    fun `숫자가 아닌 값 입력`(input: String){
        assertThrows<IllegalArgumentException> {
            lottoWinningNumberInputValidator.validate(input)
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["0","46","999","-1"])
    fun `1~45 범위 초과`(input: String){
        assertThrows<IllegalArgumentException> {
            lottoWinningNumberInputValidator.validate(input)
        }
    }


}