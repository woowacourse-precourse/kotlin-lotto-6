package lotto.controller

import lotto.view.LottoView

class LottoController {
    private val lottoView = LottoView()

    fun run() {
        lottoView.getPurchaseAmount()
    }
}