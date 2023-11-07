package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compare(winningNumbers: WinningNumbers): WinningState {
        TODO()
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
