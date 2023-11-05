package lotto

import lotto.ui.presenter.LottoPresenter
import lotto.ui.view.ConsoleLottoView

fun main() {
    val view = ConsoleLottoView()
    val presenter = LottoPresenter(view = view)

    LottoSimulator(view = view, presenter = presenter).start()
}
