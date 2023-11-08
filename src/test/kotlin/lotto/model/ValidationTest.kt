package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class ValidationTest {

    @Test
    @DisplayName("구입 금액 입력 테스트")
    fun `숫자가 아닌 문자를 입력한 경우 예외 발생`() {
        val input = "횟수"
        assertThrows<IllegalArgumentException> {
            Validation.getPurchaseAmount(input)
        }
    }

    @Test
    @DisplayName("구입 금액 입력 테스트")
    fun `구입 단위가 1000원이 아닌 경우 예외 발생`() {
        val input = "1200"
        assertThrows<IllegalArgumentException> {
            Validation.getPurchaseAmount(input)
        }
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    fun `숫자가 아닌 문자를 입력할 경우 예외 발생`() {
        val input = "횟수"
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    fun `쉼표가 없는 경우 예외 발생`() {
        val input = "1 2 3"
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    fun `6개의 숫자를 입력하지 않은 경우 예외 발생`() {
        val input = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    fun `1~45 사이의 숫자가 아닌 경우 예외 발생`() {
        val input = "1,2,3,4,5,100"
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    fun `같은 숫자를 입력한 경우 예외 발생`() {
        val input = "1,2,3,4,5,5"
        assertThrows<IllegalArgumentException> {
            Validation.getAnswerNumber(input)
        }
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    fun `숫자가 아닌 경우 예외 발생`() {
        val input = "횟수"
        assertThrows<IllegalArgumentException> {
            Validation.getBonusNum(input)
        }
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    fun `1 ~ 45 사이의 숫자가 아닌 경우 예외 발생`() {
        val input = "1,2"
        assertThrows<IllegalArgumentException> {
            Validation.getBonusNum(input)
        }
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    fun `여러 숫자를 입력한 경우 예외 발생`() {
        val input = "1,2,3,4,5,5"
        assertThrows<IllegalArgumentException> {
            Validation.getBonusNum(input)
        }
    }

}