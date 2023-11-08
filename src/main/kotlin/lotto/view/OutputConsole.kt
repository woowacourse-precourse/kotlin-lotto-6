package lotto.view

import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import java.text.NumberFormat
import java.util.*

object OutputConsole {

    fun promptForMoney() {
        println(INPUT_MONEY)
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        with(lottoTickets) {
            println(String.format(TICKET_QUANTITY_MESSAGE, size))
            forEach { println(it.toString()) }
        }
    }

    fun promptForWinningNumbers() {
        println(INPUT_WINNING_NUMBER)
    }

    fun promptForBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }

    fun printErrorMessage(exception: IllegalArgumentException) {
        println(ERROR_MESSAGE_START_PAD + "${exception.message}")
    }

    fun printInvalidNumbers() {
        println(ERROR_MESSAGE_START_PAD + INVALID_FORMAT_FOR_NUMBERS)
    }

    fun printNonNumericMessage() {
        println(ERROR_MESSAGE_START_PAD + INVALID_NUMBERS)
    }

    fun printWinningRanks(rankCount: Map<Rank, Int>) {
        Rank.entries
            .filterNot { it == Rank.NONE }
            .forEach { rank ->
                val bonusString = if (rank.isBonus) BONUS_BALL_MATCHED else ""
                val formattedAmount = formatNumberWithCommas(rank.winningAmount)
                println(
                    String.format(
                        WINNING_RANKS_TEMPLATE,
                        rank.countOfMatch,
                        bonusString,
                        formattedAmount,
                        rankCount[rank] ?: 0
                    )
                )
            }
    }


    private fun formatNumberWithCommas(number: Int): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
        return numberFormat.format(number)
    }

    fun printProfit(profit: Double) {
        println(String.format(PROFIT_STRING_FORMAT, profit))
    }

    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val TICKET_QUANTITY_MESSAGE = "%d개를 구매했습니다."
    private const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    private const val ERROR_MESSAGE_START_PAD = "[ERROR] "
    private const val INVALID_NUMBERS = "숫자만 입력해 주세요"
    private const val INVALID_FORMAT_FOR_NUMBERS = "콤마로 구분된 숫자만 입력해 주세요"
    private const val BONUS_BALL_MATCHED = ", 보너스 볼 일치"
    private const val WINNING_RANKS_TEMPLATE = "%d개 일치%s (%s원) - %d개"
    private const val PROFIT_STRING_FORMAT = "총 수익률은 %.1f%%입니다."
}