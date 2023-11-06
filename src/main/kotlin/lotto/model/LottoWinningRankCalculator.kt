package lotto.model

import lotto.Lotto

class LottoWinningRankCalculator {
    fun calculateRank(lotteryTickets: MutableList<Lotto>, winNumber: List<Int>, bonusNumber: Int): MutableMap<LottoRank, Int> {
        val wonLotto = mutableMapOf<LottoRank, Int>().withDefault { 0 }
        var prize = 0

        lotteryTickets.forEach { lotto ->
            val rank = compareLottoNumbers(lotto.getLottoNumbers(), winNumber, bonusNumber)
            if (rank != LottoRank.NONE) {
                prize += rank.prize
                wonLotto[rank] = wonLotto.getValue(rank) + 1
            }
        }
        return wonLotto
    }

    private fun compareLottoNumbers(lottoNumber: List<Int>, winNumber: List<Int>, bonusNumber: Int): LottoRank {
        var winCount = 0
        var isBonus = false
        lottoNumber.forEach { number ->
            when {
                winNumber.contains(number) -> winCount++
                number == bonusNumber -> isBonus = true
            }
        }
        return setRank(winCount, isBonus)
    }

    private fun setRank(winCount: Int, isBonus: Boolean): LottoRank {
        return when (winCount) {
            6 -> LottoRank.FIRST
            5 -> {
                if (isBonus) LottoRank.SECOND
                else LottoRank.THIRD
            }
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> LottoRank.NONE
        }
    }
}