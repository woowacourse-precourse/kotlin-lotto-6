package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class ValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["횟수", "1200"])
    fun `로또 구입 금액 입력 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation.getPurchaseAmount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["횟수","1 2 3","1,2,3,4,5","1,2,3,4,5,100","1,2,3,4,5,5"])
    fun `당첨 번호 입력 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["횟수","100","1,2"])
    fun `보너스 번호 입력 테스트`(input:String) {
        val input = "1,2"
        assertThrows<IllegalArgumentException> {
            Validation.getBonusNum(input)
        }
    }

}