package lotto.domain

import lotto.constants.isDuplicateErrorMessage

data class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        isDuplicate()
    }

    fun sortNumbers(): List<Int> {
        return numbers.sorted()
    }

    private fun isDuplicate() {
        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException(isDuplicateErrorMessage)
        }
    }

    private fun countHit(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    private fun checkBonusHit(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber: Int): Rank {
        val hit = countHit(winningNumbers)
        val bonusHit = checkBonusHit(bonusNumber)
        return Rank.of(hit, bonusHit)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
