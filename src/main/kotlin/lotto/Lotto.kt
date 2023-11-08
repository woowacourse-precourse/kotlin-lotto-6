package lotto
import lottoView.LottoOutPut
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput
import kotlin.IllegalArgumentException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkNumbersSize()
        numbersRange()
    }


    private fun checkNumbersSize() {
        if (numbers.size != 6) throw IllegalArgumentException("[ERROR]숫자는 6개씩 입력되어야합니다.")
        if (numbers.toSet().size != numbers.size) throw IllegalArgumentException("[ERROR]중복 데이터를 확인해주세요")
    }

    private fun numbersRange() {
        numbers.forEach {
            if (1 > it || it > 45) throw IllegalArgumentException("[ERROR]숫자의 범위가 잘못되었습니다.")
        }
    }

    fun getLottoNumberString(): String {
        return numbers.sorted().toString()
    }
    fun getRank(winningNumbers: List<Int>, bonusNumber : Int) : Int {
        return when(findMatch(winningNumbers)){
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

    private fun findMatch(winningNumbers: List<Int>) : Int {
        var matchNumbers = 0
        winningNumbers.forEach {
            if(numbers.contains(it)) matchNumbers++
        }
        return matchNumbers
    }
}
