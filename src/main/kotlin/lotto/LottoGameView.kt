package lotto

class LottoGameView {

    fun startInputLottoMoney() {
        println(INPUT_MONEY)
    }

    fun inputUserLottoNumber() {
        println(INPUT_LOTTO_NUMBERS)
    }

    fun inputBonusNumber() {
        println(INPUT_BONUS)
    }

    fun printMatchedNumbersCount() {
        println(SHOW_MATCH_PROFIT)
        println(SHOW_PROFIT_LINE)
        Calculator().lottoResult.forEach { (rank, count) ->
            val prize = rank.prize
            println("${rank.statement} (${prize.toDecimalFormat()}$MONEY_WON) - ${count}$COUNT")
        }
    }

    fun Long.toDecimalFormat(): String {
        return String.format("%,d", this)
    }

    fun printProfitRate(profitRate: Float) {
        println("$ALL_PRICE_RATE ${"%.1f".format(profitRate)}%입니다.")
    }

    companion object {
        private const val INPUT_MONEY = "구입 금액을 입력해주세요"
        private const val INPUT_LOTTO_NUMBERS = "당첨번호를 입력해주세요"
        private const val INPUT_BONUS = "보너스 번호를 입력해주세요"
        private const val SHOW_MATCH_PROFIT = "당첨 통계"
        private const val SHOW_PROFIT_LINE = "---"
        private const val MONEY_WON = "원"
        private const val COUNT = "개"
        private const val ALL_PRICE_RATE = "총 수익률은"
    }
}