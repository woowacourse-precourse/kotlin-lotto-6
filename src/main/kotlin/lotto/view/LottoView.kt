package lotto.view

import lotto.enums.LottoResult
import lotto.enums.OutPut
import java.text.DecimalFormat

class LottoView {
    fun printEnterPurchaseMessage() {
        println(OutPut.PLEASE_INPUT_AMOUNT.message)
    }

    fun printEnterWinningNumberMessage() {
        println(OutPut.PLEASE_INPUT_WINNING_NUMBER.message)
    }

    fun printEnterBonusNumberMessage() {
        println(OutPut.PLEASE_INPUT_BOUNS_NUMBER.message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}${OutPut.PURCHASED.message}")
        lottoNumbers.forEach { numbers ->
            println(numbers.sorted())
        }
    }

    fun displayResults(results: MutableMap<LottoResult, Int>) {
        println(OutPut.WINNING_STATISTICS.message)
        println(OutPut.NEW_LINE.message)
        val dec = DecimalFormat("#,###")
        results.entries.forEach { (lottoResult, amount) ->
            println("${lottoResult.message} (${dec.format(lottoResult.prizeAmount)}원) - ${amount}개")
        }
    }

    fun displayProfit(profit: Double) {
        println(OutPut.TOTAL_PROFIT_IS.message.format(profit))
    }
}