package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == GameConst.NUM_COUNT)
        require(numbers.distinct().size == numbers.size)
        require(numbers.all {
            it in 1..GameConst.MAX_NUM
        })
    }

    fun checkWinning(winningNumber: WinningNumber, checker: WinningStrategyEnum) : Boolean{
        return checker.calculate(numbers, winningNumber)
    }
}
