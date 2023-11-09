package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ERROR_NOT_SIX_NUMBERS_MENTION }
        require(numbers.distinct().size == 6) { ERROR_REDUNDANT_NUMBER_MENTION }
        require(numbers.all { it in 1 .. 45 }) { ERROR_NUMBER_OUT_OF_BOUND_METION }
    }

    fun getLottoNumberString() : String {
        return numbers.sorted().toString()
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber : Int) : Int {
        return when(getMatchNumbers(winningNumbers)){
            3 -> 5
            4 -> 4
            6 -> 1
            5 -> {
                if(numbers.contains(bonusNumber)) 2
                else 3
            }
            else -> 0
        }
    }

    fun getMatchNumbers(winningNumbers: List<Int>) : Int {
        var matchNumbers = 0
        winningNumbers.forEach {
            if(numbers.contains(it)) matchNumbers++
        }
        return matchNumbers
    }

    companion object {
        const val ERROR_NOT_SIX_NUMBERS_MENTION = "[ERROR] 로또에는 6개의 숫자가 필요합니다."
        const val ERROR_REDUNDANT_NUMBER_MENTION = "[ERROR] 중복되지 않은 6개의 숫자가 필요합니다."
        const val ERROR_NUMBER_OUT_OF_BOUND_METION = "[ERROR] 6개의 숫자는 1~45 사이의 숫자여야 합니다."
    }
}
