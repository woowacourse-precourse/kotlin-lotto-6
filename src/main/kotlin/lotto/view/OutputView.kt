package lotto.view

object OutputView {

    fun printLottoNumbers(lottoNumbers: List<Int>) {
        println("[${lottoNumbers.sorted().joinToString(", ")}]")
    }

    fun printLottoCount(purchaseCount: Int) {
        println("\n$purchaseCount$RESULT_AMOUNT_PURCHASE_MESSAGE")
    }

    fun printLottoWin(winCount: Int, money: Int, bonus: Boolean, prizeCount: Int) {
        if (bonus) {
            println(LOTTO_WIN_BONUS_MESSAGE.format(winCount, money.addCommas(), prizeCount))
        } else {
            println(LOTTO_WIN_MESSAGE.format(winCount, money.addCommas(), prizeCount))
        }
    }

    fun printResult() {
        println("\n$RESULT_MESSAGE")
        println(DIVIDE_LINE)
    }

    fun printResultRate(totalMoney: Long, purchaseMoney: Int) {
        println(RESULT_RATE_MESSAGE.format((totalMoney.toDouble() / purchaseMoney.toDouble()) * 100))
    }

    private fun Int.addCommas(): String {
        return String.format("%,d", this)
    }

    private const val RESULT_MESSAGE = "당첨 통계"
    private const val DIVIDE_LINE = "---"
    private const val LOTTO_WIN_MESSAGE = "%d개 일치 (%s원) - %d개"
    private const val LOTTO_WIN_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
    private const val RESULT_AMOUNT_PURCHASE_MESSAGE = "개를 구매했습니다."
    private const val RESULT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다."
}