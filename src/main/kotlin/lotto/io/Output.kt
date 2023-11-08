package lotto.io

import lotto.Messages
import lotto.Rate
import lotto.domain.Position
import java.text.DecimalFormat

object Output {
    fun printPleaseInputBudget() = print(Messages.PLEASE_INPUT_BUDGET)
    fun printHowMuchBought(amount: Int) = print("$amount${Messages.AFTER_BOUGHT}")
    fun printPleaseInputWinningNumbers() = print(Messages.PLEASE_INPUT_WINNING_NUMBERS)
    fun printPleaseInputBonusNumbers() = print(Messages.PLEASE_INPUT_BONUS_NUMBERS)
    fun printWinningStatistics(statistics: Map<Position, Int>) {
        println(Messages.WINNING_STATISTICS)
        println("---")
        val decimalFormat = DecimalFormat("#,###")
        statistics.toSortedMap().forEach {
            if (it.key == Position.NoLuck) {
                return@forEach
            }
            val formattedPrize = decimalFormat.format(it.key.winningPrize)
            println("${it.key.message} ($formattedPrize) - ${it.value}개")
        }
    }
    fun printProfitRate(rate: Rate) = println("총 수익률은 ${rate}입니다.")
}
