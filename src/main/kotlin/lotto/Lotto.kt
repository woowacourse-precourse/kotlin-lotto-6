package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        Validator.lottoLength(numbers)
        Validator.duplication(numbers)
        Validator.lottoRange(numbers)
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

}
