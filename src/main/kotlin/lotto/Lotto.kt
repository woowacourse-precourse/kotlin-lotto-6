package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        vaildateLength()
        validateDuplication()
        validateBound()
    }

    private fun vaildateLength() {
        require(numbers.size == 6) { SIZEERROR }
    }

    private fun validateBound(){
        numbers.forEach{
            require(it >= LottoInput.MIN_NUMBER && it <= LottoInput.MAX_NUMBER) { LottoInput.NUMBEROUTOFBOUND }
        }
    }
    private fun validateDuplication() {
        require(numbers.size == numbers.distinct().count()) { ERRORDUPLICATION }
    }

    fun matchingNum(winningNumber: List<Int>, bonus: Int): Int {
        var result = 0
        winningNumber.forEach { if (numbers.contains(it)) result++ }
        if (result == 5 && numbers.contains(bonus)) return 7
        return result
    }

    fun printLotto() {
        println(numbers.sorted())
    }

    companion object {
        const val SIZE = 6
        const val SIZEERROR = "ERROR: 로또 번호를 ${SIZE} 보다 적거나 많이 입력했습니다.."
        const val ERRORDUPLICATION = "ERROR: 입력하신 로또 번호는 중복이 있습니다."
    }

}
