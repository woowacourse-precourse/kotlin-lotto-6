package lotto

class Calculator {
    private val FIFTH_PRIZE = 5000
    private val FOURTH_PRIZE = 50000
    private val THRID_PRIZE = 1500000
    private val SECOND_PRIZE = 30000000
    private val FIRST_PRIZE = 2000000000
    private var jackpot3 = 0
    private var jackpot4 = 0
    private var jackpot5 = 0
    private var jackpot5WithBonus = 0
    private var jackpot6 = 0

    fun showAllCalculation() {
        print("\n당첨 통계\n---\n")
        println("3개 일치 (${FIFTH_PRIZE}원) - ${jackpot3}개")
        println("4개 일치 (${FOURTH_PRIZE}원) - ${jackpot4}개")
        println("5개 일치 (${THRID_PRIZE}원) - ${jackpot5}개")
        println("5개 일치, 보너스 볼 일치 (${SECOND_PRIZE}원) - ${jackpot5WithBonus}개")
        println("6개 일치 (${FIRST_PRIZE}원) - ${jackpot6}개")
    }

    fun calculateAllJackpot(
        lottos: List<Lotto>,
        bonuses: List<Int>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {

        lottos.mapIndexed { index, lotto ->
            if (is3Jackpot(lotto, winningNumbers)) {
                jackpot3 += 1
            }
            if (is4Jackpot(lotto, winningNumbers)) {
                jackpot4 += 1
            }
            if (is5Jackpot(lotto, winningNumbers)) {
                jackpot5 += 1
            }
            if (is5JackpotWithBonus(lotto, bonuses[index], winningNumbers, bonusNumber)) {
                jackpot5WithBonus += 1
            }
            if (is6Jackpot(lotto, winningNumbers)) {
                jackpot6 += 1
            }
        }
    }

    private fun countMatchNumber(winningNumbersIter: Iterator<Int>, lottoIter: Iterator<Int>): Int {
        var count = 0
        var winningNumbersTarget = winningNumbersIter.next()
        var lottoNumbersTarget = lottoIter.next()

        while (winningNumbersIter.hasNext() && lottoIter.hasNext()) {
            if (winningNumbersTarget == lottoNumbersTarget) {
                count += 1
                winningNumbersTarget = winningNumbersIter.next()
                lottoNumbersTarget = lottoIter.next()
            } else if (winningNumbersTarget > lottoNumbersTarget) {
                lottoNumbersTarget = lottoIter.next()
            } else if (winningNumbersTarget < lottoNumbersTarget) {
                winningNumbersTarget = winningNumbersIter.next()
            }
        }

        return count
    }

    private fun is3Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        val matchCount = countMatchNumber(winningNumbers.iterator(), lotto._numbers.iterator())
        return matchCount == 3
    }

    private fun is4Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        val matchCount = countMatchNumber(winningNumbers.iterator(), lotto._numbers.iterator())
        return matchCount == 4
    }

    private fun is5Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        val matchCount = countMatchNumber(winningNumbers.iterator(), lotto._numbers.iterator())
        return matchCount == 5
    }

    private fun is5JackpotWithBonus(lotto: Lotto, bonus: Int, winningNumbers: List<Int>, bonusNumber: Int): Boolean {
        val matchCount = countMatchNumber(winningNumbers.iterator(), lotto._numbers.iterator())
        return matchCount == 5 && bonus == bonusNumber
    }

    private fun is6Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        val matchCount = countMatchNumber(winningNumbers.iterator(), lotto._numbers.iterator())
        return matchCount == 6
    }

}