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
            if (correctCount == LottoResource.NUMBER_OF_BRANCH_2ND_AND_3RD)
                isBonusCorrect = it.compareBonusNumber(target.bonusNumber)
            val rank = checkRank(correctCount, isBonusCorrect)
            takeRankPrize(rank)
        }
        printStatistics()
    }
    fun checkRank(correctCount: Int, bonusCount: Boolean): Rank {
        val currentRank: Rank = when (correctCount) {
            Rank.FIRST.correctCount -> Rank.FIRST
            LottoResource.NUMBER_OF_BRANCH_2ND_AND_3RD -> when (bonusCount) {
                true -> Rank.SECOND
                false -> Rank.THIRD
            }
            Rank.FOURTH.correctCount -> Rank.FOURTH
            Rank.FIFTH.correctCount -> Rank.FIFTH
            else -> Rank.NO_PRIZE
        }
        return currentRank
    }
    fun checkRank(place: Int): Rank {
        val rank: Rank = when (place) {
            Rank.FIRST.rank -> Rank.FIRST
            Rank.SECOND.rank -> Rank.SECOND
            Rank.THIRD.rank -> Rank.THIRD
            Rank.FOURTH.rank -> Rank.FOURTH
            Rank.FIFTH.rank -> Rank.FIFTH
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
        val originPrice = ownLotto.countOfLotto * LottoResource.LOTTO_PRICE
        val profitRate = round(((profitSum.toDouble() / originPrice.toDouble() * 100) * 100)) / 100
        println("총 수익률은 ${profitRate}%입니다.")
    }
    fun printPerPlacePrize(rank: Int) {
        val currentRank = checkRank(rank)
        println(currentRank.message + "${winCount[rank]}개")
    }
}