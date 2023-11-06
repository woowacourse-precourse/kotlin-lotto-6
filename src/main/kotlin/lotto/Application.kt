package lotto

import lotto.controller.LottoManager
import lotto.view.OutputView

fun main() {
    val lottoMng = LottoManager(OutputView)

    runCatching {
        lottoMng.run()
    }.onFailure {e ->
        println(e.message)
    }
}
