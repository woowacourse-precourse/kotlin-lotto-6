package lotto.view

import lotto.message.Exception
import lotto.enums.LottoResult
import lotto.message.OutPut.THREE_N_DASH
import lotto.message.OutPut.PLEASE_INPUT_AMOUNT
import lotto.message.OutPut.PLEASE_INPUT_BONUS_NUMBER
import lotto.message.OutPut.PLEASE_INPUT_WINNING_NUMBER
import lotto.message.OutPut.PURCHASED
import lotto.message.OutPut.TOTAL_PROFIT_IS
import lotto.message.OutPut.WINNING_STATISTICS
import java.text.DecimalFormat

class LottoView {
    fun printEnterPurchaseMessage() {
        println(PLEASE_INPUT_AMOUNT)
    }

    fun printEnterWinningNumberMessage() {
        println(PLEASE_INPUT_WINNING_NUMBER)
    }

    fun printEnterBonusNumberMessage() {
        println(PLEASE_INPUT_BONUS_NUMBER)
    }

    fun printErrorAndRetryMessage(message: String, e: IllegalArgumentException) {
        println("${Exception.ERROR_HEADER} ${e.message}")
        println(message)
    }

    fun displayLottoNumbers(lottoNumbers: List<List<Int>>) {
        println("${lottoNumbers.size}${PURCHASED}")
        lottoNumbers.forEach { numbers ->
            println(numbers.sorted())
        }
    }

    fun displayResults(results: MutableMap<LottoResult, Int>) {
        println(WINNING_STATISTICS)
        println(THREE_N_DASH)
        results.entries.forEach { (lottoResult, amount) ->
            println("${lottoResult.message} (${DecimalFormat("#,###").format(lottoResult.prizeAmount)}원) - ${amount}개")
        }
    }

    fun displayProfit(profit: Double) {
        println(TOTAL_PROFIT_IS.format(profit))
    }
}