package lotto

import lotto.domain.Purchase
import lotto.Output
import lotto.domain.WinningNumber
import lotto.domain.BonusNumber

fun main() {

    //purchase도 싱글턴으로 될거 같은데..
    val lottoCount = Purchase.getLottoCountFromAmount()
    Output.printLottoCount(lottoCount)
    Purchase.getLottoNumber(lottoCount)
    Output.printLottoNumber()
    val winningNumbers = WinningNumber.getWinningNumbers()
    val bonusNumber = BonusNumber.getBonusNumber()
    println(winningNumbers)
    println(bonusNumber)
}
