package lotto

import lotto.domain.Customer
import lotto.domain.Lotto
import lotto.domain.LottoManager
import lotto.ui.LottoCustomerScreen
import lotto.ui.LottoManagerScreen

fun main() {
    val lottoManager = LottoManager()
    lottoManager.startLotto()
}
