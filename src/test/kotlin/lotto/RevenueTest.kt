package lotto

import org.junit.jupiter.api.Test
import revenue.PriceChart

class RevenueTest {
    @Test
    fun `등수별 당첨횟수를 통해 총 상금을 계산한다`(){
        val ranking = listOf(3,1,0,0,0)
        val answer = 65000
        var totalReward = 0
        for (index in ranking.indices){
            totalReward += PriceChart.values()[index].price * ranking[index]
        }
        require(answer == totalReward)
    }

    @Test
    fun `사용한 금액과 당첨금액을 비교하여 수익률을 구한다`() {
        val totalReward = 65000
        val priceOfUser = 163000
        val answer = 0.3987730061349693

        val rateOfRevenue = totalReward.toDouble() / priceOfUser
        require(answer == rateOfRevenue)
    }

    @Test
    fun `수익률을 백분율로 나타내고 소수점 둘째자리에서 반올림한다`(){
        val rateOfRevenue = 0.3987730061349693 * 100
        val roundRate: Double = Math.round(rateOfRevenue * 10.0) / 10.0
        val answer = 39.9
        require(roundRate == answer)
    }
}