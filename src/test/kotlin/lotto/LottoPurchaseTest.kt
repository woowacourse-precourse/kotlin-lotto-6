package lotto

import lotto.validation.CheckInputValidation
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class LottoPurchaseTest {
    private val inputValidation = CheckInputValidation()

    @Test
    fun `공백 입력 유효성 검사`() {
        val input = "10000"
        assertThat(inputValidation.checkIsBlank(input))
    }

    @Test
    fun `사용자가 공백을 입력했다면 예외 발생`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsBlank(input)
        }
    }

    @Test
    fun `숫자 입력 유효성 검사`() {
        val input = "10000"
        assertThat(inputValidation.checkIsNumber(input))
    }

    @Test
    fun `사용자 입력이 숫자가 아니라면 예외 발생`() {
        val input = "만원"
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsNumber(input)
        }
    }

    @Test
    fun `양의 정수 유효성 검사`() {
        val input = "10000"
        assertThat(inputValidation.checkIsPositiveInteger(input))
    }

    @Test
    fun `사용자 입력이 양의 정수가 아니라면 예외 발생`() {
        val input = "-10000"
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsPositiveInteger(input)
        }
    }

    @Test
    fun `천 단위 금액 입력 유효성 검사`() {
        val input = 10000
        assertThat(inputValidation.checkIsCorrectCost(input))
    }

    @Test
    fun `사용자 입력이 천 단위 금액이 아니라면 예외 발생`() {
        val input = 10100
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsCorrectCost(input)
        }
    }

    @Test
    fun `천원 이상 금액 유효성 검사`() {
        val input = 1000
        assertThat(inputValidation.checkIsEnoughCost(input))
    }

    @Test
    fun `사용자 입력이 금액이 충분하지 않다면 예외 발생`() {
        val input = 100
        assertThrows<IllegalArgumentException> {
            inputValidation.checkIsEnoughCost(input)
        }
    }
}