package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun computeWinState(winNumberList: List<Int>, bonusNumber: Int): WinState {
        var countCorrectNumber = 0
        val isCorrectBonusNumber = bonusNumber in this.numbers
        this.numbers.forEach { number ->
            countCorrectNumber += isInWinNumberList(number, winNumberList)
        }
        return createWinState(countCorrectNumber, isCorrectBonusNumber)
    }

    private fun createWinState(countCorrectNumber: Int, correctBonusNumber: Boolean): WinState {
        return when (countCorrectNumber) {
            3 -> WinState.THREE
            4 -> WinState.FOUR
            5 -> correctBonusWinState(correctBonusNumber)
            6 -> WinState.SIX
            else -> WinState.NONE
        }
    }

    private fun correctBonusWinState(correctBonusNumber: Boolean): WinState {
        return if (correctBonusNumber) {
            WinState.FIVEPLUSBONUS
        } else {
            WinState.FIVE
        }
    }

    private fun isInWinNumberList(number: Int, winNumberList: List<Int>): Int {
        return if (number in winNumberList) {
            1
        } else {
            0
        }
    }
}
