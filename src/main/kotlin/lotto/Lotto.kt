package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printWinningNumbers() {
        println("[${numbers.joinToString()}]")
    }

    fun checkWinning(userInputNumbers: Set<Int>, userInputBonusNumber: Int): Winning? {
        val intersectCnt = userInputNumbers.intersect(numbers).size
        val isBonusNumberMatched = numbers.contains(userInputBonusNumber)
        return when (intersectCnt) {
            3 -> Winning.MatchingThreeCount
            4 -> Winning.MatchingFourCount
            5 -> {
                if (isBonusNumberMatched) Winning.MatchingFiveCountWithBonus
                Winning.MatchingFiveCount
            }

            6 -> Winning.MatchingSixCount
            else -> null
        }
    }
}
