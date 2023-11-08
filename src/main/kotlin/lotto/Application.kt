package lotto

import lotto.controller.LottoController
import lotto.model.LottoNumber
import lotto.model.LottoWinningRankCalculator
import lotto.model.ProfitCalculator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(
        outputView = OutputView(),
        inputView = InputView(),
        lottoNumber = LottoNumber(),
        lottoWinningRankCalculator = LottoWinningRankCalculator(),
        profitCalculator = ProfitCalculator()
    ).run()
}
