package lotto

import lotto.domain.Purchase
import lotto.Output
import lotto.domain.WinningNumber
import lotto.domain.BonusNumber
import lotto.domain.Winning

fun main() {

    //purchase도 싱글턴으로 될거 같은데..
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