package lotto.model

import lotto.util.LottoView


enum class InputErrorCode(val message: String) {
    NUMBER_IN_RANGE("[Error] 1에서 45 사이의 숫자여야 합니다."),
    NUMBERS_NOT_VALID("[Error] 당첨 번호에 빈칸 혹은 문자열이 포함되어 있습니다."),
    REPEATED_NUMBER("[Error] 입력 값 중 중복된 숫자가 있습니다.")
}
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            InputErrorCode.NUMBERS_NOT_VALID.message
        }
        validateNumbers()
        validateRepeat()
    }


    private fun validateNumbers() {
        require(numbers.all { it in 1..45 }) {
            InputErrorCode.NUMBER_IN_RANGE.message
        }
    }

    private fun validateRepeat() {
        require(numbers.distinct().size == 6) {
            InputErrorCode.REPEATED_NUMBER.message
        }
    }

    private fun bonusCheck(inputNumbers: List<Int>, bonus: Int) : Boolean {
        val frequency = inputNumbers.count { it == bonus }
        return frequency == 1
    }
    private fun matchNumber(inputNumbers: List<Int>, bonusNum: Int) : Pair<Int, Boolean> {
        val difference = inputNumbers.minus(numbers.toSet())
        val duplicationCount = inputNumbers.size - difference.size
        val rank = when (duplicationCount) {
            3 -> 5
            4 -> 4
            5 -> 3
            6 -> 1
            else -> 0
        }
        val check = (rank == 3 && bonusCheck(inputNumbers, bonusNum))
        return Pair(rank, check)
    }

    fun compareLotto(lottoNumbers: MutableList<List<Int>>, bonusNum: Int) : MutableList<Int> {
        val lottoResult = mutableListOf(0,0,0,0,0)
        lottoNumbers.forEach { lottoList ->
            val result = matchNumber(lottoList, bonusNum)
            if(result.first == 3 && result.second) {
                lottoResult[1] += 1
            } else if(result.first > 0) {
                lottoResult[result.first - 1] += 1
            }
        }
        LottoView().prizeStatusView(lottoResult)
        return lottoResult
    }

}
