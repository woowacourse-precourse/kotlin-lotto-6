package lotto.view

import lotto.constants.message.ExceptionMessage
import lotto.enums.LottoResult
import lotto.constants.message.OutputMessage
import java.text.DecimalFormat

class LottoView {
    fun displayMessage(outputMessage: String) {
        println(outputMessage)
    }

    fun printErrorAndRetryMessage(message: String, e: IllegalArgumentException) {
        println("${ExceptionMessage.ERROR_HEADER} ${e.message}")
        println(message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}${OutputMessage.PURCHASED}")
        lottoNumbers.forEach { numbers ->
            println(numbers)
        }
    }

    fun displayResults(results: MutableMap<LottoResult, Int>) {
        println(OutputMessage.WINNING_STATISTICS)
        println(OutputMessage.THREE_N_DASH)
        results.entries.forEach { (lottoResult, amount) ->
            println("${lottoResult.message} (${DecimalFormat("#,###").format(lottoResult.prizeAmount)}${OutputMessage.WON}) - ${amount}${OutputMessage.EA}")
        }
    }

    fun displayProfit(profit: Double) {
        println(OutputMessage.TOTAL_PROFIT_IS.format(profit))
    }
}