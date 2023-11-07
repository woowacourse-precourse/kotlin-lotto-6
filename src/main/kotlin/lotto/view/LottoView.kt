package lotto.view

import lotto.constants.message.ExceptionMessage
import lotto.enums.LottoResult
import lotto.constants.message.OutPutMessage
import java.text.DecimalFormat

class LottoView {
    fun printEnterPurchaseMessage() {
        println(OutPutMessage.PLEASE_INPUT_AMOUNT)
    }

    fun printEnterWinningNumberMessage() {
        println(OutPutMessage.PLEASE_INPUT_WINNING_NUMBER)
    }

    fun printEnterBonusNumberMessage() {
        println(OutPutMessage.PLEASE_INPUT_BONUS_NUMBER)
    }

    fun printErrorAndRetryMessage(message: String, e: IllegalArgumentException) {
        println("${ExceptionMessage.ERROR_HEADER} ${e.message}")
        println(message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}${OutPutMessage.PURCHASED}")
        lottoNumbers.forEach { numbers ->
            println(numbers.sorted())
        }
    }

    fun displayResults(results: MutableMap<LottoResult, Int>) {
        println(OutPutMessage.WINNING_STATISTICS)
        println(OutPutMessage.THREE_N_DASH)
        results.entries.forEach { (lottoResult, amount) ->
            println("${lottoResult.message} (${DecimalFormat("#,###").format(lottoResult.prizeAmount)}${OutPutMessage.WON}) - ${amount}${OutPutMessage.EA}")
        }
    }

    fun displayProfit(profit: Double) {
        println(OutPutMessage.TOTAL_PROFIT_IS.format(profit))
    }
}