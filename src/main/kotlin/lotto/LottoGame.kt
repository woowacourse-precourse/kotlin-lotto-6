package lotto

class LottoGame(
    private val lottoTickets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private val lottoResults : HashMap<LottoResultCase,Int> = hashMapOf()
    private val lottoCost : Int = lottoTickets.size * 1000
    fun matchLottoNumbers() {
        lottoTickets.forEach { lotto ->
            val lottoNumbers = lotto.getNumbers()
            var equalNumberCount = countCommonLottoNumbers(lottoNumbers)
            if (isBonus(lottoNumbers)){
                equalNumberCount++
            }
            val lottoResult = LottoResult(equalNumberCount,isBonus(lottoNumbers))
            val resultCase = checkResultCase(lottoResult)


            lottoResults[resultCase] = lottoResults[resultCase]?.plus(1) ?: 1
        }
        displayLottoGameResult()

    }

    fun displayLottoGameResult() {
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${lottoResults[LottoResultCase.THREE_CORRECT] ?: 0}개")
        println("4개 일치 (50,000원) - ${lottoResults[LottoResultCase.FOUR_CORRECT] ?: 0}개")
        println("5개 일치 (1,500,000원) - ${lottoResults[LottoResultCase.FIVE_CORRECT] ?: 0}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResults[LottoResultCase.FIVE_CORRECT_AND_BONUS] ?: 0}개")
        println("6개 일치 (2,000,000,000원) - ${lottoResults[LottoResultCase.SIX_CORRECT] ?: 0}개")
    }

    private fun countCommonLottoNumbers(lottoNumbers: List<Int>): Int {
        var count = 0
        winningNumbers.forEach {
            if (lottoNumbers.contains(it)) {
                count++
            }
        }
        return count
    }

    private fun isBonus (lottoNumbers: List<Int>) : Boolean = if(lottoNumbers.contains(bonusNumber)) true else false
    private fun checkResultCase(lottoResult: LottoResult): LottoResultCase{
        return when{
            lottoResult.winningCount == 3 ->LottoResultCase.THREE_CORRECT
            lottoResult.winningCount == 4 ->LottoResultCase.FOUR_CORRECT
            lottoResult.winningCount == 5 ->LottoResultCase.FIVE_CORRECT
            lottoResult.winningCount == 5 && lottoResult.isBonus == true -> LottoResultCase.FIVE_CORRECT_AND_BONUS
            lottoResult.winningCount == 6 -> LottoResultCase.SIX_CORRECT
            else -> LottoResultCase.UNKNOWN
        }
    }

    data class LottoResult(val winningCount: Int, val isBonus: Boolean)

    enum class LottoResultCase{
        THREE_CORRECT,
        FOUR_CORRECT,
        FIVE_CORRECT,
        FIVE_CORRECT_AND_BONUS,
        SIX_CORRECT,
        UNKNOWN
    }

}