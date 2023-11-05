package lotto

import lotto.utils.validator.LottoCostInputValidator
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCostInputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1400","1","234","1005","1010"])
    fun `로또 구입 금액이 1000원 단위가 아닌 경우`(string : String){
        assertThrows<IllegalArgumentException> { LottoCostInputValidator.isValidCost(string.toIntOrNull())}
    }

    @ParameterizedTest
    @ValueSource(strings = ["c","c12","-1","-1c","0"])
    fun `로또 구입 금액이 자연수가 아닌 경우`(string : String){
        assertThrows<IllegalArgumentException> { LottoCostInputValidator.isValidCost(string.toIntOrNull())}
    }

}