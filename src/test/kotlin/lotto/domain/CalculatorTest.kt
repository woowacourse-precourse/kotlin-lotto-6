package lotto.domain

import lotto.model.LottoManager
import lotto.model.Winning
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    private val calculator = Calculator()
    private lateinit var reward: HashMap<Winning, Int>

    @BeforeEach
    fun setUp() {
        reward = HashMap()
        reward[Winning.makeRewardStatistics(3, false)] = 1
        reward[Winning.makeRewardStatistics(4, false)] = 1
    }

    @Test
    fun `상금 총합 계산 테스트`() {
        val totalWinning = calculator.addTotalEarnings(reward)

        assertEquals(55000, totalWinning)
    }

    @Test
    fun `수익률 계산 테스트`() {
        val yield = calculator.calculateYield(5000,reward)

        assertEquals("1100.0",yield)
    }


}