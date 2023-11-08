package lotto

import lotto.model.WinningNumber
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WinningNumberTest {

    @Test
    fun `유효한 당첨번호 사이즈 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf("1", "2", "3", "4", "5", "6")
        winningNumber.isWinningNumberSize(input)
    }

    @Test
    fun `유효하지 않은 당첨번호 사이즈 테스트 `() {
        val winningNumber = WinningNumber()
        val input = listOf("1", "2", "3", "4")
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            winningNumber.isWinningNumberSize(input)
        }
    }

    @Test
    fun `유효한 당첨번호 숫자 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf("1", "2", "3", "4", "5", "6")
        winningNumber.isWinningNumberNumeric(input)
    }

    @Test
    fun `유효하지 않은 당첨번호 숫자 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf("1", "2", "3", "A", "5", "6")
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            winningNumber.isWinningNumberNumeric(input)
        }
    }

    @Test
    fun `유효한 당첨번호 범위 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf(1, 2, 3, 4, 5, 6)
        winningNumber.isWinningNumberRange(input)
    }

    @Test
    fun `유효하지 않은 당첨번호 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf(1, 2, 54, 3, 5, 6)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            winningNumber.isWinningNumberRange(input)
        }
    }

    @Test
    fun `유효한 당첨번호 중복 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf(1, 2, 3, 4, 5, 6)
        winningNumber.isWinningNumberDuplicate(input)
    }

    @Test
    fun `유효하지 않은 당첨번호 중복 테스트`() {
        val winningNumber = WinningNumber()
        val input = listOf(1, 4, 4, 4, 4, 6)
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            winningNumber.isWinningNumberDuplicate(input)
        }
    }
}