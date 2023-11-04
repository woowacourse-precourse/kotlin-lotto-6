package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또에는 6개의 숫자가 필요합니다." }
        require(numbers.distinct().size == 6) { "[ERROR] 중복되지 않은 6개의 숫자가 필요합니다." }
    }

    fun getLottoNumberString() : String {
        return numbers.sorted().toString()
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber : Int) : Int {
        val matchNumbers = getMatchNumbers(winningNumbers)
        return when(matchNumbers){
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
}
