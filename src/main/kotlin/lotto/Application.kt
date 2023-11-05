package lotto

import lotto.io.input.Input
import lotto.io.output.Output
import lotto.model.lotto.LottoSupplier

fun main() {
    val input = Input()
    val output = Output()
    val lottoSupplier = LottoSupplier()
    val lottoController = LottoController(input, output, lottoSupplier)

    lottoController.run()
}
