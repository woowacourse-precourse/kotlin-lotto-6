package lotto

import lotto.validation.CheckInputValidation
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputLottoNumberTest {
    private val inputValidation = CheckInputValidation()

    @Test
    fun `사용자 입력이 로또 번호(1~45 사이 수)에 대한 유효성 검사`() {
        val input = "45"
        Assertions.assertThat(inputValidation.checkIsLottoNumber(input))
    }

    @Test
    fun `사용자 입력이 로또 번호가 아니라면 예외 발생`() {
        val input = "100"
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsLottoNumber(input)
        }
    }

    @Test
    fun `로또 번호에 중복 값에 대한 유효성 검사`() {
        val input = listOf(1,2,3,4,5,6)
        Assertions.assertThat(inputValidation.checkDuplication(input))
    }

    @Test
    fun `로또 번호에 중복 값이 있다면 예외 발생`() {
        val input = listOf(1,2,3,4,5,5)
        assertThrows<IllegalArgumentException> {
            inputValidation.checkDuplication(input)
        }
    }

    @Test
    fun `보너스 번호가 로또 번호에 대한 중복 값이 있는지 유효성 검사`() {
        val numbers = setOf(1,2,3,4,5,6)
        val bonus = 45
        Assertions.assertThat(
            inputValidation.checkBonusNumberDuplication(
                numbers, bonus
            )
        )
    }

    @Test
    fun `보너스 번호가 로또 번호에 대한 중복 값이 있다면 예외 발생`() {
        val numbers = setOf(1,2,3,4,5,6)
        val bonus = 6
        assertThrows<IllegalArgumentException> {
            inputValidation.checkBonusNumberDuplication(
                numbers, bonus
            )
        }
    }

    @Test
    fun `로또 번호 갯수에 대한 유효성 검사`() {
        val input = listOf("1","2","3","4","5","6")
        Assertions.assertThat(inputValidation.checkLottoCount(input))
    }

    @Test
    fun `로또 번호 갯수가 6이 아니라면 예외 발생`() {
        val input = listOf("1","2","3","4","5","6","7")
        assertThrows<IllegalArgumentException> {
            inputValidation.checkLottoCount(input)
        }
    }
}