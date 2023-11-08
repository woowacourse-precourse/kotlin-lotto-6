package lotto

import lotto.domain.LottoCompare
import lotto.domain.LottoMake
import lotto.domain.LottoWinning
import lotto.domain.Validation
import lotto.presentation.LottoDecisionView.inputBonusNumber
import lotto.presentation.LottoDecisionView.inputWinningNumber
import lotto.presentation.LottoDecisionView.printBonusNumber
import lotto.presentation.LottoDecisionView.printWinningNumber
import lotto.presentation.LottoPurchaseView.inputLottoPurchase
import lotto.presentation.LottoPurchaseView.outputPurchaseCount
import lotto.presentation.LottoPurchaseView.printLottoPurchase
import lotto.presentation.LottoWinningView.outputProfitRate
import lotto.presentation.LottoWinningView.printWinningStatic

fun main() {
    printLottoPurchase()
    val amount = Validation().validationAmount(inputLottoPurchase())
    val count = outputPurchaseCount(amount)
    val lotto = LottoMake().resultLottoNumber(count)
    println()
    printWinningNumber()
    val winningNumber = inputWinningNumber().sorted() // winningNumber 얻음
    val winningCount = LottoCompare(lotto).compare(winningNumber)
    println()
    printBonusNumber()
    val bonusNumber = inputBonusNumber() // bonusNumber 얻음
    val bonusCount = LottoCompare(lotto).compareBonus(bonusNumber)
    println()
    printWinningStatic()
    LottoWinning(winningCount, bonusCount).calculate()
    val profit = LottoWinning(winningCount, bonusCount).profit(amount)
    outputProfitRate(profit)
}
