package lotto.domain.service

import lotto.Lotto
import lotto.domain.model.Customer
import lotto.domain.model.Winning
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoCalculatorTest {
    lateinit var lottoCalculator: LottoCalculator

    @BeforeEach
    fun `setUp`(){
        lottoCalculator = LottoCalculator(Winning(listOf(1,2,3,4,5,6),7))
    }

    @Test
    fun `로또 번호가 5개 보너스 번호 포함된 등수가 2등이 아닐 경우 예외 발생`(){
        val rank = lottoCalculator.checkWinningRank(Lotto(listOf(1,2,3,4,5,7)))
        val expected = 2
        Assertions.assertEquals(expected,rank)
    }

    @Test
    fun `로또 번호가 5개 포함된 등수가 3등이 아닐 경우 예외 발생`(){
        val rank = lottoCalculator.checkWinningRank(Lotto(listOf(1,2,3,4,5,8)))
        val expected = 3
        Assertions.assertEquals(expected,rank)
    }

    @Test
    fun `로또 번호가 2개 이하일 경우 등수가 6등이 아닐 경우 예외 발생`(){
        val rank = lottoCalculator.checkWinningRank(Lotto(listOf(1,2,8,9,10,12)))
        val expected = 6
        Assertions.assertEquals(expected,rank)
    }

}