package lotto

import lotto.controller.LottoController
import lotto.model.LottoModel
import lotto.view.LottoView

fun main() {
    val lottoModel = LottoModel()
    val lottoView = LottoView()
    val lottoController = LottoController(lottoModel, lottoView)
    lottoController.startLotto()
}
