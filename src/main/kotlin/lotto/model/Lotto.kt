package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6)
    }

    fun printNumbers() {
        println(this.numbers)
    }

    fun compareLottoNumber(winningNumber: Lotto): Int {
        val result = winningNumber.getNumbers().filter { number ->
            this.numbers.contains(number)
        }
        return result.size
    }

    fun compareBonusNumber(bonusNumber: Int): Boolean {
        return this.numbers.indexOf(bonusNumber) >= 0
    }

    private fun getNumbers(): List<Int> {
        return this.numbers
    }
}
