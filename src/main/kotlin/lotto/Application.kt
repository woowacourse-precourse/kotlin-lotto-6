package lotto

import lotto.controller.LottoManager
import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoManger = LottoManager()
    lottoManger.runApplication()
}
