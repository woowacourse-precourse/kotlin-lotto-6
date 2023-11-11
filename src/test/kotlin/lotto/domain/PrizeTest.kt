package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun prizeTest() {
        val testPrize = Prize()
        val testList = mutableListOf<Grade>()
        testList.add(Grade.FIFTH)
        val testMoney = 1000
        val testResult = testPrize.getPrizeRatio(testList, testMoney)
        Assertions.assertThat(testResult).isEqualTo("500.0")
    }

    @Test
    fun prizeRatioTest() {
        val testPrize = Prize()
        val testList = mutableListOf<Grade>()
        testList.add(Grade.FIFTH)
        testList.add(Grade.FOURTH)
        val testMoney = 3000
        val testResult = testPrize.getPrizeRatio(testList, testMoney)
        Assertions.assertThat(testResult).isEqualTo("1833.3")
    }

    @Test
    fun prizeRatioRoundUpTest() {
        val testPrize = Prize()
        val testList = mutableListOf<Grade>()
        testList.add(Grade.FIFTH)
        testList.add(Grade.FOURTH)
        val testMoney = 6000
        val testResult = testPrize.getPrizeRatio(testList, testMoney)
        Assertions.assertThat(testResult).isEqualTo("916.7")
    }

    @Test
    fun prizeSumTest() {
        val testPrize = Prize()
        val testList = mutableListOf<Grade>()
        for (i in 1..100) {
            testList.add(Grade.FIRST)
        }
        val testMoney = 3
        val testResult = testPrize.getPrizeRatio(testList, testMoney)
        Assertions.assertThat(testResult).isEqualTo("6666666666666.7")
    }
}