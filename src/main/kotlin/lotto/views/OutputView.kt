package lotto.views

import lotto.models.Lotto
import lotto.models.WinningRank
import lotto.models.WinningRecord
import lotto.utils.Extensions.withCommas

class OutputView {

    fun printPurchasedLottos(purchasedLottos: List<Lotto>) {
        println(PURCHASED_LOTTO_COUNT_MESSAGE.format(purchasedLottos.size))

        purchasedLottos.forEach {
            val formattedLottoNumbers = formatLottoNumbers(it)
            println(PURCHASED_LOTTO_NUMBERS_MESSAGE.format(formattedLottoNumbers))
        }

        println()
    }

    private fun formatLottoNumbers(lotto: Lotto): String = lotto.getNumbers().joinToString(LOTTO_NUMBER_SEPARATOR)

    fun printWinningStatics(winningRecord: WinningRecord) {
        println(WINNING_STATISTICS_MESSAGE)

        val winningRanks = WinningRank.getWithoutNothing()
        winningRanks.forEach {
            val winningCount = winningRecord.value[it] ?: 0
            val staticsMessage = generateStaticsMessage(it, winningCount)

            println(staticsMessage)
        }

        println()
    }

    private fun generateStaticsMessage(rank: WinningRank, winningCount: Int): String {
        val messageTemplate = if (rank.hasBonus) WINNING_WITH_BONUS_MESSAGE else WINNING_WITHOUT_BONUS_MESSAGE

        return messageTemplate.format(rank.macthCount, rank.amount.withCommas(), winningCount)
    }

    fun printProfitRate(profitRate: Double) = println(PROFIT_RATE_MESSAGE.format(profitRate))

    fun printErrorMessage(message: String?) = println("$ERROR_MESSAGE_PREFIX ${message ?: UNKNOWN_ERROR_MESSAGE}\n")

    companion object {
        const val PURCHASED_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다."
        const val PURCHASED_LOTTO_NUMBERS_MESSAGE = "[%s]"

        const val LOTTO_NUMBER_SEPARATOR = ", "

        const val WINNING_STATISTICS_MESSAGE = "당첨 통계\n---"
        const val WINNING_WITHOUT_BONUS_MESSAGE = "%d개 일치 (%s원) - %d개"
        const val WINNING_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"

        const val PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."

        const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        const val UNKNOWN_ERROR_MESSAGE = "알 수 없는 에러가 발생했습니다."
    }
}