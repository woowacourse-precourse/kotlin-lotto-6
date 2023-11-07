package lotto

fun main() {
    val input = InputValue()
    val winningBonus = WinningAndBonusNumber(input.inputWinningNumber(), input.inputBonusNumber())

    println(winningBonus.winningNumber)
    println(winningBonus.bonusNumber)
}
