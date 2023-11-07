package lotto.domain.service

import lotto.Lotto
import lotto.domain.model.Customer
import lotto.domain.model.Winning
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinningCalculatorTest {
    lateinit var winningCalculator: WinningCalculator

    @BeforeEach
    fun `setUp`(){
        val customer = Customer()
        customer.lotteries.add(Lotto(listOf(1,2,3,4,5,6)))
        customer.lotteries.add( Lotto(listOf(1,2,3,4,5,8)))
        customer.lotteries.add( Lotto(listOf(1,2,3,4,5,8)))
        winningCalculator = WinningCalculator(Winning(listOf(1,2,3,4,5,6),8), customer)
    }

    @Test
    fun `로또의 순위가 1등 1개 2등 2개가 아닐 경우에 예외가 발생 한다 `(){
        val first = 1
        val second = 2
        val winningRanks = winningCalculator.getWinningRanks()
        assertEquals(1,winningRanks[first])
        assertEquals(2,winningRanks[second])
    }

    @Test
    fun `총 수익률의 계산이 틀리면 오류가 발생 한다`(){
        val customer = Customer()
        customer.lotteries.add(Lotto(listOf(1,8,3,10,11,12)))
        customer.lotteries.add(Lotto(listOf(1,4,6,10,15,18)))
        winningCalculator = WinningCalculator(Winning(listOf(1,2,3,4,5,6),8), customer)
        assertEquals("250.0%",winningCalculator.getTotalReturnPercent())

    }


}