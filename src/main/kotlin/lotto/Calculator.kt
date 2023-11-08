package lotto

import java.text.DecimalFormat

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
    private lateinit var profitRate: String

    fun calculateProfitRate(budget: Int): String {
        val profit: Double =
            (jackpot3 * FIFTH_PRIZE + jackpot4 * FOURTH_PRIZE + jackpot5 * THRID_PRIZE + jackpot5WithBonus * SECOND_PRIZE + jackpot6 * FIRST_PRIZE).toDouble()
        profitRate = String.format("%.1f", profit / budget.toDouble() * 100)

        return profitRate
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

    private fun countMatchNumber(lotto: Lotto, winningNumbers: List<Int>): Int {
        var count = 0
        val difference = lotto._numbers.toSet().minus(winningNumbers.toSet())
        difference.joinToString()
        count = winningNumbers.size - difference.size

        return count
    }

    fun showAllCalculation() {
        val dec = DecimalFormat("#,###")
        print("\n당첨 통계\n---\n")
        println("3개 일치 (${dec.format(FIFTH_PRIZE)}원) - ${jackpot3}개")
        println("4개 일치 (${dec.format(FOURTH_PRIZE)}원) - ${jackpot4}개")
        println("5개 일치 (${dec.format(THRID_PRIZE)}원) - ${jackpot5}개")
        println("5개 일치, 보너스 볼 일치 (${dec.format(SECOND_PRIZE)}원) - ${jackpot5WithBonus}개")
        println("6개 일치 (${dec.format(FIRST_PRIZE)}원) - ${jackpot6}개")
    }

    fun showProfitRate() {
        println("총 수익률은 ${profitRate}%입니다.")
    }

    fun is3Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        return countMatchNumber(lotto, winningNumbers) == 3
    }

    fun is4Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        return countMatchNumber(lotto, winningNumbers) == 4
    }

    fun is5Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        return countMatchNumber(lotto, winningNumbers) == 5
    }

    fun is5JackpotWithBonus(lotto: Lotto, bonus: Int, winningNumbers: List<Int>, bonusNumber: Int): Boolean {
        return countMatchNumber(lotto, winningNumbers) == 5 && bonus == bonusNumber
    }

    fun is6Jackpot(lotto: Lotto, winningNumbers: List<Int>): Boolean {
        return lotto._numbers == winningNumbers
    }
}