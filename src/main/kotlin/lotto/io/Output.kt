package lotto.io

import lotto.Messages
import lotto.Rate
import lotto.domain.Lotto
import lotto.domain.Position
import java.text.DecimalFormat

object Output {
    fun printPleaseInputBudget() = println(Messages.PLEASE_INPUT_BUDGET)
    fun printHowMuchBought(amount: Int) = println("$amount${Messages.AFTER_BOUGHT}")
    fun printPleaseInputWinningNumbers() = println(Messages.PLEASE_INPUT_WINNING_NUMBERS)
    fun printListOfLottoNumbers(list: List<Lotto>) = list.forEach { println(it) }
    fun printPleaseInputBonusNumbers() = println(Messages.PLEASE_INPUT_BONUS_NUMBERS)
    fun printWinningStatistics(statistics: Map<Position, Int>) {
        println(Messages.WINNING_STATISTICS)
        println("---")
        val decimalFormat = DecimalFormat("#,###")
        val emptyMap = mutableMapOf(
            Position.Fifth to 0,
            Position.Fourth to 0,
            Position.Third to 0,
            Position.Second to 0,
            Position.First to 0,
        )
        statistics.forEach {
            emptyMap[it.key] = it.value
        }
        emptyMap.forEach {
            if (it.key == Position.NoLuck) {
                return@forEach
            }
            val formattedPrize = decimalFormat.format(it.key.winningPrize)
            println("${it.key.message} (${formattedPrize}원) - ${it.value}개")
        }
    }
    fun printProfitRate(rate: Rate) = println("총 수익률은 ${rate}입니다.")
}
