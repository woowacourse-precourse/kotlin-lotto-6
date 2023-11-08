package lotto

import lotto.consts.GameConst
import lotto.consts.ErrorStringRes
import lotto.lotto.winning.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberTest {
    @Test
    fun `중복 된 당첨 번호`() {
        assertThrows<IllegalArgumentException>(ErrorStringRes.NUMBER_RANGE_ERR) {
            val base = WinningNumber(listOf(1, 1, 1, 1, 1, 1), 3)
        }
    }

    @Test
    fun `범위를 벗어난 당첨 번호`() {
        val target = GameConst.MAX_NUM + 1
        assertThrows<IllegalArgumentException>(ErrorStringRes.NUMBER_RANGE_ERR) {
            val base = WinningNumber(listOf(target, 1, 2, 3, 4, 5), 6)
        }
    }

    @Test
    fun `범위를 벗어난 보너스 번호`() {
        val target = GameConst.MAX_NUM + 1
        assertThrows<IllegalArgumentException>(ErrorStringRes.NUMBER_RANGE_ERR) {
            val base = WinningNumber(listOf(1, 2, 3, 4, 5, 6), target)
        }
    }

    @Test
    fun `보너스 번호와 당첨 번호의 중복`() {
        assertThrows<IllegalArgumentException>(ErrorStringRes.NUMBER_RANGE_ERR) {
            val base = WinningNumber(listOf(1, 2, 3, 4, 5, 6), 1)
        }
    }

    @Test
    fun `올바른 당첨 번호`() {
        assertThat(WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7).numbers).contains(1, 2, 3, 4, 5, 6)

        assertThat(WinningNumber(listOf(1, 2, 3, 4, 5, 6), 7).bonus).isEqualTo(7)
    }
}