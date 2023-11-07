package lotto.view

object OutputView {
    private const val RESULT_MESSAGE = "\n당첨 통계"
    private const val DIVIDE_LINE = "---"
    private const val LOTTO_WIN_MESSAGE = "%d개 일치 (%s원) - %d개"
    private const val LOTTO_WIN_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    private const val RESULT_AMOUNT_PURCHASE_MESSAGE = "\n%d개를 구매했습니다."
    private const val RESULT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
    private const val SEPARATOR_COMMA = ", "

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println("[${lottoNumbers.sorted().joinToString(SEPARATOR_COMMA)}]")
    }

    fun printLottoCount(purchaseCount: Int) {
        println(RESULT_AMOUNT_PURCHASE_MESSAGE.format(purchaseCount))
    }

    fun printLottoWin(winCount: Int, money: Int, bonus: Boolean, prizeCount: Int) {
        if (bonus) {
            println(LOTTO_WIN_BONUS_MESSAGE.format(winCount, money.addCommas(), prizeCount))
        } else {
            println(LOTTO_WIN_MESSAGE.format(winCount, money.addCommas(), prizeCount))
        }
    }

    fun printResult() {
        println(RESULT_MESSAGE)
        println(DIVIDE_LINE)
    }

    fun printResultRate(totalMoney: Long, purchaseMoney: Int) {
        println(RESULT_RATE_MESSAGE.format((totalMoney.toDouble() / purchaseMoney.toDouble()) * 100))
    }

    private fun Int.addCommas(): String {
        return String.format("%,d", this)
    }
}