package lotto

fun main() {
    val input = InputValue()

    val winning = input.inputWinningNumber()
    val bonus = input.inputBonusNumber(winning)

    val winningBonus = WinningAndBonusNumber(winning, bonus)


}