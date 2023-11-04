package lotto

import lotto.domain.Purchase
import lotto.domain.WinningNumber
import lotto.domain.BonusNumber
import lotto.domain.Winning

fun main() {

    val lottoCount = Purchase.getLottoCountFromAmount()
    Output.printLottoCount(lottoCount)

    Purchase.getLottoNumber(lottoCount)
    Output.printLottoNumber()

    WinningNumber.inputWinningNumbers()

    BonusNumber.inputBonusNumber()

    Winning.setWinningRateCount()

    Output.printWinningRate()
    Output.printEarningRate(Winning.calculateEarningRate(lottoCount))
}