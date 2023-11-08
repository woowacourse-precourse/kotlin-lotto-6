package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class WinningNumberTest {

    companion object {
        private lateinit var winningNumber: WinningNumber
        
        private const val userInput = "1,2,3,4,5,6"
        private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        @BeforeAll
        @JvmStatic
        fun setUp() {
            winningNumber = WinningNumber
        }
    }


    @Test
    fun `사용자가 정상적인 값을 입력했을 때 당첨 번호 반환`() {
        val received = winningNumber.userInputToWinningNumber(userInput)
        Assertions.assertThat(received).isEqualTo(winningNumbers)
    }

    @Test
    fun `로또 번호의 개수가 6개가 아니면 예외 발생`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            winningNumber.userInputToWinningNumber("1,2,3,4,5")
        }
    }

    @Test
    fun `로또 번호가 Int가 아니면 예외 발생`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            winningNumber.userInputToWinningNumber("감,2,3,4,5,6")
        }
    }

    @Test
    fun `로또 번호가 1 ~ 45가 아니면 예외 발생`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            winningNumber.userInputToWinningNumber("54646,2,3,4,5,6")
        }
    }
}