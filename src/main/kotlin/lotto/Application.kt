package lotto

import lotto.controller.LottoSystemController
import lotto.view.LottoSystemView

fun main() {
    var lottoSystemView = LottoSystemView()
    var lottoSystemController = LottoSystemController(lottoSystemView)
    lottoSystemController.run()
}
