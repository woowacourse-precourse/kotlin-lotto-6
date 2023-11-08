package lotto.view

import lotto.domain.Lotto
import lotto.domain.WinningRank
    import java.text.DecimalFormat

class OutputView {
    private val moneyDecimal = DecimalFormat("#,###")

    fun printAskPurchaseMoney() {
        println(INPUT_MONEY_MESSAGE)
    }

    fun printPurchaseLottoQuantity(quantity: Int) {
        println(String.format(PURCHASE_LOTTO_QUANTITY_MESSAGE, quantity))
        print(BLANK_LINE)
    }

    fun printLotto(lotto: List<Lotto>) {
        lotto.forEach {
            println("[${it.joinToString(", ")}]")
        }
    }

    fun printAskWinningNumber() {
        println(INPUT_WINNING_NUMBERS_MESSAGE)
    }

    fun printAskBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }

    fun printRank(rank: Map<WinningRank, Int>) {
        println(WINNING_RANK_MESSAGE)
        println(SEPARATOR)
        rank.filter { it.key != WinningRank.NO_MATCHES }.forEach { entry ->
            println("${entry.key.message} (${moneyDecimal.format(entry.key.winningPrize)}원) - ${entry.value}개")
        }
    }

    fun printRevenue(revenue: Double) {
        println(String.format(TOTAL_REVENUE_MESSAGE, revenue.toString()))
    }

    companion object {
        private const val BLANK_LINE = "\n"
        private const val INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요."
        private const val PURCHASE_LOTTO_QUANTITY_MESSAGE = "%d개를 구매했습니다."
        private const val INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val WINNING_RANK_MESSAGE = "당첨 통계"
        private const val SEPARATOR = "---"
        private const val TOTAL_REVENUE_MESSAGE = "총 수익률은 %s%%입니다."
    }
}