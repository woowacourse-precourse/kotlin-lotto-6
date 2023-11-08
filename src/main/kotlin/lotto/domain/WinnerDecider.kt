package lotto.domain

import kotlin.collections.*

class WinnerDecider(
    private val winningLottoNumbers: String,
    private val bonus: String,
    private val userLottos: List<Lotto>
) {

    init {
        setWinningCount(winningCount)
    }
    fun makeJudgement() {
        val targetNumbers = parseNumbers()
        val bonusNumber = parseBonusNumber()
        for (lotto in userLottos) {
            val matchCount=lotto.comparetoTarget(targetNumbers)
            val hasBonusNumber=lotto.compareToBonus(bonusNumber)
            calculateRank(matchCount,hasBonusNumber)
        }
    }

    private fun setWinningCount(winningCount : MutableMap<Int,Int>){
        winningCount.put(FIRST, COUNT)
        winningCount.put(SECOND,COUNT)
        winningCount.put(THIRD,COUNT)
        winningCount.put(FOURTH,COUNT)
        winningCount.put(FIFTH,COUNT)
        winningCount.put(NONE,COUNT)

    }
    private fun calculateRank(matchCount:Int, hasBonusNumber : Boolean){
        when (matchCount) {
            6 -> winningCount.replace(FIRST,winningCount.getValue(FIRST)+1)
            5 -> if(hasBonusNumber) {winningCount.replace(SECOND,winningCount.getValue(SECOND)+1)}
                else{winningCount.replace(THIRD,winningCount.getValue(THIRD)+1)}
            4 -> winningCount.replace(FOURTH,winningCount.getValue(FOURTH)+1)
            3 -> winningCount.replace(FIFTH,winningCount.getValue(FIFTH)+1)
            else -> winningCount.replace(NONE,winningCount.getValue(NONE)+1)
        }
    }

    private fun calculateRateOfReturn() {

    }

    private fun parseNumbers(): List<Int> {
        return winningLottoNumbers.split(',').map { it.toInt() }
    }

    private fun parseBonusNumber(): Int {
        return bonus.toInt()
    }

    companion object {
        private const val COUNT = 0
        private const val FIRST = 1
        private const val SECOND = 2
        private const val THIRD = 3
        private const val FOURTH = 4
        private const val FIFTH = 5
        private const val NONE = -999

        val winningCount = mutableMapOf<Int, Int>()

    }

}