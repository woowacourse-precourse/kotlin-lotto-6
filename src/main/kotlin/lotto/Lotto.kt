package lotto

import java.util.*

class Lotto(private val numbers: List<Int>) {
    companion object{
        private const val NUMBER_IN_RANGE = "[Error] 1에서 45 사이의 숫자여야 합니다."
        private const val NUMBERS_NOT_VALID = "[Error] 입력 값이 6개가 아니거나 당첨 번호에 문자열이 포함되어 있습니다."
        private const val REPEATED_NUMBER = "[Error] 입력 값 중 중복된 숫자가 있습니다."
    }
    init {
        require(numbers.size == 6){
            NUMBERS_NOT_VALID
        }
        validateNumbers()
        validateRepeat()
    }


    private fun validateNumbers() {
        for (number in numbers) {
            if (number !in 1..45) {
                throw IllegalArgumentException(NUMBER_IN_RANGE)
            }
        }
    }

    private fun validateRepeat(){
        val checkRepeat = mutableListOf<Int>()
        for(number in numbers){
            if(number in checkRepeat){
                throw IllegalArgumentException(REPEATED_NUMBER)
            }
            checkRepeat.add(number)
        }
    }

    private fun bonusCheck(inputNumbers: List<Int>, bonus: Int): Boolean{
        val frequency = Collections.frequency(inputNumbers, bonus)
        return frequency == 1
    }
    private fun matchNumber(inputNumbers: List<Int>, bonusNum: Int): Pair<Int, Boolean> {
        val difference = inputNumbers.minus(numbers)
        val duplicationCount = inputNumbers.size - difference.size
        var rank = 0
        var check = false
        when (duplicationCount) {
            3 -> rank = 5
            4 -> rank = 4
            5 -> {
                rank = 3
                check = bonusCheck(inputNumbers, bonusNum)
            }
            6 -> rank = 1
        }
        return Pair(rank, check)
    }

    fun compareLotto(lottoNumbers: MutableList<List<Int>>, bonusNum: Int) : MutableList<Int> {
        val lottoResult = mutableListOf(0,0,0,0,0)
        lottoNumbers.forEach { lottoList ->
            val result = matchNumber(lottoList, bonusNum)
            if(result.first == 3 && result.second) {
                lottoResult[1] += 1
            } else if(result.first > 0)
                lottoResult[result.first-1] += 1
        }
        LottoView().prizeStatusView(lottoResult)
        return lottoResult
    }

    fun lottoProfit(invest: Int,totalResult: List<Int>){
        var profit = 0.0
        profit += totalResult[0] * 2000000000
        profit += totalResult[1] * 30000000
        profit += totalResult[2] * 1500000
        profit += totalResult[3] * 50000
        profit += totalResult[4] * 5000
        val profitMargin = profit / invest * 100
        LottoView().totalRate(profitMargin)
    }

}
