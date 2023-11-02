package lotto

import lotto.domain.Purchase
import lotto.Output
fun main() {

    //purchase도 싱글턴으로 될거 같은데..
    val purchase = Purchase()
    val lottoCount = purchase.getLottoCountFromAmount()
    Output.printLottoCount(lottoCount)
    purchase.getLottoNumber(lottoCount)
}
