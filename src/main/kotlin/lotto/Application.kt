package lotto

import lotto.controller.LottoManager
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMng = LottoManager(InputView, OutputView)

    runCatching {
        lottoMng.run()
    }.onFailure {e ->
        println(e.message)
    }
}
