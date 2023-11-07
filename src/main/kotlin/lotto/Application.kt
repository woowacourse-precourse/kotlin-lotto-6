package lotto

fun main() {
    val input = InputValue()
    val winningBonusClass = WinningAndBonusNumber(input.inputWinningNumber(), input.inputWinningNumber())

    println(winningBonusClass.winningNumber)
    println(winningBonusClass.bonusNumber)
}
