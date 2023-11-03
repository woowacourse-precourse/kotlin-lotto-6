package lotto

import lotto.controller.LottoController
import lotto.view.OutputView

fun main() {
    LottoController(
        outputView = OutputView()
    ).run()
}
