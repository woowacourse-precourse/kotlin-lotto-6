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
            3 -> Winning.matchingThreeCount
            4 -> Winning.matchingFourCount
            5 -> {
                if (isBonusNumberMatched) Winning.matchingFiveCountWithBonus
                Winning.matchingFiveCount
            }

            6 -> Winning.matchingSixCount
            else -> null
        }
    }
}
