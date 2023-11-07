package lotto

import lotto.io.input.Input
import lotto.io.output.Output
import lotto.service.LottoSupplier
import lotto.service.WinningCalculator

fun main() {
    val input = Input()
    val output = Output()
    val lottoSupplier = LottoSupplier()
    val winningCalculator = WinningCalculator()
    val lottoController = LottoController(input, output, lottoSupplier, winningCalculator)

    lottoController.run()
}
