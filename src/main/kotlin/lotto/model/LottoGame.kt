package lotto.model

import kotlin.math.roundToInt

class LottoGame(
    private val lottoTickets: List<Lotto>,
    private val lottoWinningNumbers: LottoWinningNumbers
) {
    private val lottoResults: HashMap<LottoResultCase, Int> = hashMapOf()
    private val lottoCost: Int = lottoTickets.size * 1000
    fun matchLottoNumbers() {
        lottoTickets.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            var equalNumberCount = countCommonLottoNumbers(lottoNumbers)
            if (isBonus(lottoNumbers)) {
                equalNumberCount++
            }
            val resultCase = checkResultCase(equalNumberCount, isBonus(lottoNumbers))

            lottoResults[resultCase] = lottoResults[resultCase]?.plus(1) ?: 1
        }
        displayLottoGameResult()
    }

    private fun displayLottoGameResult() {
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${lottoResults[LottoResultCase.THREE_CORRECT] ?: 0}개")
        println("4개 일치 (50,000원) - ${lottoResults[LottoResultCase.FOUR_CORRECT] ?: 0}개")
        println("5개 일치 (1,500,000원) - ${lottoResults[LottoResultCase.FIVE_CORRECT] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResults[LottoResultCase.FIVE_CORRECT_AND_BONUS] ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${lottoResults[LottoResultCase.SIX_CORRECT] ?: 0}개")
        println("총 수익률은 ${calculateLottoProfit()}%입니다.")
    }

    private fun calculateLottoProfit(): Double {
        val profit = calculateTotalPrize() / lottoCost.toDouble() * 100.0
        return (profit * 100.0).roundToInt() / 100.0
    }

    private fun calculateTotalPrize(): Int {
        var totalPrize = 0
        lottoResults.forEach { lottoResultCase, value ->
            when (lottoResultCase) {
                LottoResultCase.THREE_CORRECT -> totalPrize += 5000
                LottoResultCase.FOUR_CORRECT -> totalPrize += 50000
                LottoResultCase.FIVE_CORRECT -> totalPrize += 1500000
                LottoResultCase.FIVE_CORRECT_AND_BONUS -> totalPrize += 30000000
                LottoResultCase.SIX_CORRECT -> totalPrize += 2000000000
                else -> {}
            }
        }
        return totalPrize
    }

    private fun countCommonLottoNumbers(lottoNumbers: List<Int>): Int {
        var count = 0
        lottoWinningNumbers.winningNumbers.forEach {
            if (lottoNumbers.contains(it)) {
                count++
            }
        }
        return count
    }

    private fun isBonus(lottoNumbers: List<Int>): Boolean =
        if (lottoNumbers.contains(lottoWinningNumbers.bonusNumber)) true else false

    private fun checkResultCase(winningCount: Int, isBonus: Boolean): LottoResultCase {
        return when {
            winningCount == 3 -> LottoResultCase.THREE_CORRECT
            winningCount == 4 -> LottoResultCase.FOUR_CORRECT
            winningCount == 5 -> LottoResultCase.FIVE_CORRECT
            winningCount == 5 && isBonus == true -> LottoResultCase.FIVE_CORRECT_AND_BONUS
            winningCount == 6 -> LottoResultCase.SIX_CORRECT
            else -> LottoResultCase.UNKNOWN
        }
    }

    enum class LottoResultCase {
        THREE_CORRECT,
        FOUR_CORRECT,
        FIVE_CORRECT,
        FIVE_CORRECT_AND_BONUS,
        SIX_CORRECT,
        UNKNOWN
    }

}