package lotto.validator

import lotto.utils.validator.LottoWinningNumberInputValidator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertFalse

@DisplayName("로또 당첨 번호 및 보너스 번호 입력 테스트")
class LottoWinningNumbersValidatorTest {
    private lateinit var lottoWinningNumberInputValidator : LottoWinningNumberInputValidator

    @BeforeEach
    fun `셋팅`(){
        lottoWinningNumberInputValidator = LottoWinningNumberInputValidator()
    }

    @Test
    fun `정상적인 로또 번호 입력`(){
        assert(lottoWinningNumberInputValidator.validate(listOf("1","2","3","4","5","6")))
    }

    fun `로또 번호가 6개 아닐 때`(){
        assertFalse(lottoWinningNumberInputValidator.validate(listOf("1","2","33","44","12")))
    }

    @Test
    fun `숫자가 아닌 값 입력`(){
        assertThrows<IllegalArgumentException> {
            lottoWinningNumberInputValidator.validate(listOf("1c"))
            lottoWinningNumberInputValidator.validate(listOf("`+"))
        }
    }
    @Test
    fun `1~45 범위 초과`(){
        assertThrows<IllegalArgumentException> {
            lottoWinningNumberInputValidator.validate(listOf("0"))
            lottoWinningNumberInputValidator.validate(listOf("100"))
        }
    }

    @Test
    fun `로또 당첨 번호에만 중복된 숫자가 있는 경우`(){
        assertThrows<IllegalArgumentException> { lottoWinningNumberInputValidator.validate(listOf(1,1,2,3,4,5),"1") }
    }

    @Test
    fun `로또 당첨 번호는 중복되지 않았으나 보너스 번호가 기존 번호와 중복된 경우`(){
        assertThrows<IllegalArgumentException> { lottoWinningNumberInputValidator.validate(listOf(1,2,3,4,5,6),"1") }
    }

    @Test
    fun `로또 당첨 번호, 보너스 번호 둘 다 중복이 발생한 경우`(){
        assertThrows<IllegalArgumentException> { lottoWinningNumberInputValidator.validate(listOf(1,1,3,4,5,6),"6") }
    }


}