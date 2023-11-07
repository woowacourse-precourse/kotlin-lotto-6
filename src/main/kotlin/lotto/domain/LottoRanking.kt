package lotto.domain

import lotto.util.LottoStore
import lotto.util.round

// 전체 랭킹을 다룸
class LottoRanking(var countByRanking: MutableMap<LottoResult, Int>, var totalPrize: Double) {
    companion object {
        fun of(lottoResults: List<LottoResult>): LottoRanking {

            val map = mutableMapOf<LottoResult, Int>()
            var prize = 0.0

            LottoResult.entries.forEach { result -> map[result] = 0 }

            for (result in lottoResults) {
                map[result] = (map[result] ?: 0) + 1 // 1 증가를 위한 역할
                prize += result.prize
            }

            prize = calculateROI((lottoResults.size * LottoStore.LOTTO_TICKET_PRICE), prize).round(2)
            return LottoRanking(map, prize)
        }

        private fun calculateROI(initialInvestment: Int, profit: Double): Double {
            return (profit / initialInvestment) * PERCENT_FACTOR
        }

        private const val PERCENT_FACTOR = 100
    }
}