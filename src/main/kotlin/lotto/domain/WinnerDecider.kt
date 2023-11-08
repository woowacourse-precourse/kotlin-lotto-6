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
            if(winningCount.containsKey(matchCount)){
                winningCount.replace(matchCount,winningCount.getValue(matchCount)+1)
            }
        }
    }

    private fun setWinningCount(winningCount : MutableMap<Int,Int>){
        winningCount.put(FIRST, COUNT)
        winningCount.put(SECOND,COUNT)
        winningCount.put(THIRD,COUNT)
        winningCount.put(FOURTH,COUNT)
        winningCount.put(FIFTH,COUNT)
    }
    private fun calculateRank(){

    }

    private fun calculateRateOfReturn() {

    }

    private fun parseNumbers(): List<Int> {
//        val countByRank : mutableMapOf<List<Int>, Int>
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
        val winningCount = mutableMapOf<Int, Int>()

    }

}