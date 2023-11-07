package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compare(winningNumbers: WinningNumbers): WinningState {
        val count = winningNumbers.winningNumbers.count { numbers.contains(it) }
        val bonus = numbers.contains(winningNumbers.bonusNumber)
        return if (bonus && count == 5) {
            WinningState.SECOND
        } else {
            when (count) {
                6 -> WinningState.FIRST
                5 -> WinningState.THIRD
                4 -> WinningState.FORTH
                3 -> WinningState.FIFTH
                else -> WinningState.NONE
            }
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
