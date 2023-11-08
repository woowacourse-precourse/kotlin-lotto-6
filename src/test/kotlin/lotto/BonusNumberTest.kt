package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    private val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `입력값이 숫자가 아닐 경우`() {
        val input = "글자"
        assertThrows<IllegalArgumentException> {
            BonusNumber(input, lotto)
        }
    }

    @Test
    fun `입력값이 당첨번호와 중복될 경우`() {
        val input = "1"
        assertThrows<IllegalArgumentException> {
            BonusNumber(input, lotto)
        }
    }

    @Test
    fun `입력값이 로또의 범위를 넘어갈 경우`() {
        val input = "555"
        assertThrows<IllegalArgumentException> {
            BonusNumber(input, lotto)
        }
    }
}