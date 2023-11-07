package lotto

import java.text.DecimalFormat

object Print {
    fun pleaseInputBudget() = print(Messages.PLEASE_INPUT_BUDGET)
    fun howMuchBought(amount: Int) = print("$amount${Messages.AFTER_BOUGHT}")
    fun pleaseInputWinningNumbers() = print(Messages.PLEASE_INPUT_WINNING_NUMBERS)
    fun pleaseInputBonusNumbers() = print(Messages.PLEASE_INPUT_BONUS_NUMBERS)
    fun winningStatistics(statistics: Map<Position, Int>) {
        val decimalFormat = DecimalFormat("#,###")
        val sorted = statistics.toSortedMap().forEach{
            if (it.key == Position.NoLuck) {
                return@forEach
            }
            val formattedPrize = decimalFormat.format(it.key.winningPrize)
            println("${it.key.message} (${formattedPrize}) - ${it.value}개")
        }
    }
}