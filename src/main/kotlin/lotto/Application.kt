package lotto

import lotto.domain.Purchase
import lotto.domain.WinningNumber
import lotto.domain.BonusNumber
import lotto.domain.Winning

fun main() {
    //구입 금액 입력
    val lottoCount = Purchase.getLottoCountFromAmount()
    Output.printLottoCount(lottoCount)
    //로또 번호 구하기 & 출력
    Purchase.getLottoNumber(lottoCount)
    Output.printLottoNumber()
    //당첨 번호 입력
    WinningNumber.inputWinningNumbers()
    //보너스 번호 입력
    BonusNumber.inputBonusNumber()
    //로또 등수 처리
    Winning.setWinningRateCount()
    //로또 결과 출력
    Output.printWinningRate()
    Output.printEarningRate(Winning.calculateEarningRate(lottoCount))
}