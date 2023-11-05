package lotto

import lotto.model.WinningLotto
import lotto.util.Constant
import lotto.util.Constant.INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    private val winningLotto = WinningLotto()

    @Test
    fun `당첨 번호의 개수가 6개가 아닐 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            winningLotto.setLuckyNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
        assertThrows<IllegalArgumentException> {
            winningLotto.setLuckyNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호의 숫자들은 1~45의 범위를 벗어나면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            winningLotto.setLuckyNumbers(listOf(0, 1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            winningLotto.setLuckyNumbers(listOf(1, 2, 3, 4, 5, 47))
        }
    }

    @Test
    fun `당첨 번호의 숫자가 중복되면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            winningLotto.setLuckyNumbers(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `보너스 번호가 1~45의 범위를 벗어나면 예외가 발생한다`() {
        winningLotto.setLuckyNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lowerRangeException = assertThrows<IllegalArgumentException> {
            winningLotto.setBonusNumber(0)
        }
        assertEquals(lowerRangeException.message, INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE)
        println(lowerRangeException.message)
        val upperRangeException = assertThrows<IllegalArgumentException> {
            winningLotto.setBonusNumber(47)
        }
        assertEquals(upperRangeException.message, INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE)
        println(upperRangeException.message)
    }

    @Test
    fun `보너스 번호가 당첨번호와 일치하면 예외가 발생한다`() {
        winningLotto.setLuckyNumbers(listOf(1, 2, 3, 4, 5, 6))
        val overlapException = assertThrows<IllegalArgumentException> {
            winningLotto.setBonusNumber(3)
        }
        assertEquals(overlapException.message, INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE)
        println(overlapException.message)
    }
}