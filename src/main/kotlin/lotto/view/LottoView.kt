package lotto.view

import lotto.constants.message.ExceptionMessage
import lotto.enums.LottoResult
import lotto.constants.message.OutPutMessage.THREE_N_DASH
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_AMOUNT
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_BONUS_NUMBER
import lotto.constants.message.OutPutMessage.PLEASE_INPUT_WINNING_NUMBER
import lotto.constants.message.OutPutMessage.PURCHASED
import lotto.constants.message.OutPutMessage.TOTAL_PROFIT_IS
import lotto.constants.message.OutPutMessage.WINNING_STATISTICS
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
        println("${ExceptionMessage.ERROR_HEADER} ${e.message}")
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