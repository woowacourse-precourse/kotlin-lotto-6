package lotto.view

import lotto.constant.PrintText
import lotto.domain.LottoGameResult
import lotto.domain.Lottos

class PrintOutputView {

    fun printError(message: String?) {
        println(message)
        println()
    }

    fun printRequirePurchaseAmount() {
        println(PrintText.REQUIRE_PURCHASE_AMOUNT.text)
    }

    fun printPurchaseAmount(purchaseAmount: Int) {
        println()
        println(purchaseAmount.toString() + PrintText.PRINT_PURCHASE_AMOUNT.text)
    }

    fun printRandomWinningNumbers(winningNumbers: Lottos) {
        println(winningNumbers.toLottosResult())
        PrintText.SEPARATE_LOTTES
        println()
    }

    fun requireWinningNumber() {
        println(PrintText.REQUIRE_WINNING_NUMBER.text)
    }

    fun requireBonusNumber() {
        println()
        println(PrintText.REQUIRE_BONUS_NUMBER.text)
    }

    fun printLottoSameCount(lottoResult: LottoGameResult, purchaseAmount: Int) {
        println()
        println(PrintText.PRINT_RESULT.text)
        println(PrintText.SEPARATE_RESULT.text)
        print(lottoResult.toAllSameCountResult())
        println(lottoResult.calculateEarningRate(purchaseAmount))
    }

}