package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    private val winningStatistics = WinningStatistics()

    private lateinit var winningNumber: List<Int>
    private lateinit var lotto: List<Int>
    private var bonusNumber = 0

    @BeforeEach
    fun setUp() {
        winningNumber = listOf(1, 2, 3, 4, 5, 6)
        lotto = listOf(1, 2, 3, 7, 8, 9)
        bonusNumber = 6
    }

    @Test
    fun `로또 번화 당첨 번호의 일치 테스트`() {
        val result = winningStatistics.compareLotto(lotto, winningNumber)

        assertEquals(3, result)
    }

    @Test
    fun `보너스 번호 포함 여부 테스트`() {
        val result = winningStatistics.compareBonus(winningNumber, bonusNumber)

        assertTrue(result)
    }
}