package lotto.view

import lotto.config.OutputMessages
import lotto.model.LottoCompare


class OutputView {
    fun lottoPurchaseMessage() = println(OutputMessages.PURCHASE_MONEY.message)
    fun lottoPurchaseConfirm(purchaseLottoNumber: Int)= println("\n${OutputMessages.PURCHASE_CONFIRMATION.message.format(purchaseLottoNumber)}")
    fun lottoNumbersView(lottoNumbers: MutableList<List<Int>>){
        lottoNumbers.forEach {
            println(it)
        }
    }
    fun rightLottoNumberMessage() = println("\n${OutputMessages.RIGHT_LOTTO_NUMBER.message}")
    fun bonusLottoNumberMessage() = println("\n${OutputMessages.BONUS_NUMBER.message}")

    fun lottoCompareResult(compareResult: LottoCompare) {
        val lottoResult = compareResult.calculateCorrect()
        println("\n${OutputMessages.WINNING_STATISTICS.message}\n${OutputMessages.DIVIDING_LINE_LARGE.message}")
        lottoResult.forEach{(lotto,count)->
            println("${lotto.message} ${OutputMessages.DIVIDING_LINE_SMALL.message} ${count}${OutputMessages.LOTTO_COUNT.message}")
        }
    }
    fun lottoProfit(lottoProfit:Double) {
        println(OutputMessages.YIELD_RATE_OF_RETURN.message.format(lottoProfit))
    }
 }

