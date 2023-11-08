package lotto.view

import lotto.*
import lotto.dto.PurchasedLottoDto

class OutputView {
    fun printPurchasedLottoNumber(purchasedLotto: Int) {
        println("$purchasedLotto$OUTPUT_MESSAGE_PURCHASE_RESULT")
    }

    fun printAllPurchasedLotto(purchasedLottoDtoList: MutableList<PurchasedLottoDto>) {
        for (lottoDto in purchasedLottoDtoList) {
            pritnListInBracketFormat(lottoDto.getLottoNumbers())
        }
    }

    fun printWinningResult(winStatistics: MutableList<Int>) {
        println(OUTPUT_MESSAGE_WINNING_STATISTICS)
        println(OUTPUT_MESSAGE_DIVIDER)
        println("$OUTPUT_MESSAGE_WIN_THREE${winStatistics[4]}$OUTPUT_MESSAGE_UNIT")
        println("$OUTPUT_MESSAGE_WIN_FOUR${winStatistics[3]}$OUTPUT_MESSAGE_UNIT")
        println("$OUTPUT_MESSAGE_WIN_FIVE${winStatistics[2]}$OUTPUT_MESSAGE_UNIT")
        println("$OUTPUT_MESSAGE_WIN_FIVE_WITH_BONUS${winStatistics[1]}$OUTPUT_MESSAGE_UNIT")
        println("$OUTPUT_MESSAGE_WIN_SIX${winStatistics[0]}$OUTPUT_MESSAGE_UNIT")
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("$OUTPUT_MESSAGE_RATE_OF_RETURN_1$rateOfReturn$OUTPUT_MESSAGE_RATE_OF_RETURN_2")
    }

    fun pritnListInBracketFormat(lottoList: List<Int>) {
        println(lottoList.joinToString(prefix = "[", postfix = "]", separator = ", "))
    }
}