package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun prizeTest(){
        val testPrize = Prize()
        val testList = mutableListOf<Grade>()
        testList.add(Grade.FIFTH)
        val testMoney = 1000
        val testResult = testPrize.checkPrize(testList,testMoney)
        Assertions.assertThat(testResult).isEqualTo(500.0)
    }
}