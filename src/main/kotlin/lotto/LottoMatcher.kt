package lotto

import kotlin.math.round

class LottoMatcher(val target: TargetLottoStatus, val ownLotto: LottoStatus) {
    var profitSum = 0
    var winCount = mutableListOf<Int>(0,0,0,0,0,0)
    fun startMatch() {
        var correctCount = 0
        var isBonusCorrect = false
        ownLotto.myLottos.forEach {
            correctCount = it.compareNumbers(target.lottoNumbers)
            if (correctCount == 5)
                isBonusCorrect = it.compareBonusNumber(target.bonusNumber)
            checkRank(correctCount, isBonusCorrect)
        }
        printStatistics()
    }
    fun checkRank(correctCount: Int, bonusCount: Boolean) {
        val currentRank: Rank = when (correctCount) {
            6 -> Rank.FIRST
            5 -> when (bonusCount) {
                true -> Rank.SECOND
                false -> Rank.THIRD
            }
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NO_PRIZE
        }
        takeRankPrize(currentRank)
    }
    fun checkRank(place: Int): Rank {
        val rank: Rank = when (place) {
            1 -> Rank.FIRST
            2 -> Rank.SECOND
            3 -> Rank.THIRD
            4 -> Rank.FOURTH
            5 -> Rank.FIFTH
            else -> Rank.NO_PRIZE
        }
        return rank
    }
    fun takeRankPrize(rank: Rank) {
        profitSum += rank.winnerPrize
        winCount[rank.rank]++
    }
    fun printStatistics() {
        println(LottoResource.PRINT_STATISTICS_MESSAGE)
        for (place in LottoResource.MAX_RANK_PLACE downTo LottoResource.MIN_RANK_PLACE) {
            printPerPlacePrize(place)
        }
        printProfitRate()
    }
    fun printProfitRate() {
        val originPrice = ownLotto.countOfLotto * 1000
        val profitRate = round(((profitSum.toDouble() / originPrice.toDouble() * 100) * 100)) / 100
        println("총 수익률은 ${profitRate}%입니다.")
    }
    fun printPerPlacePrize(rank: Int) {
        val currentRank = checkRank(rank)
        println(currentRank.message + "${winCount[rank]}개")
    }
}