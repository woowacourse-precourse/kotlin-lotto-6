package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun printNumbers() {
        println(this.numbers)
    }

    fun compareLottoNumber(winningNumber: WinningNumber): Int {
        val result = winningNumber.getWinningNumbers().filter { number ->
            this.numbers.contains(number)
        }
        return result.size
    }

    fun compareBonusNumber(bonusNumber: Int): Boolean {
        return this.numbers.indexOf(bonusNumber) >= 0
    }
}
