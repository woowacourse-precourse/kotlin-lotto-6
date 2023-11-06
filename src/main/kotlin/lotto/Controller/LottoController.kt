package lotto.controller

import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.view.Input
import lotto.view.Output

class LottoController {
    private val input = Input()
    private val output = Output()

    fun start() {
        val ticketCount = input.askPurchaseAmount()
        val lottos = Lottos(ticketCount)
        lottos.generateLottos()
        output.printLottos(lottos)
        val winningNumber = input.askWinningLottoNumber()
        val bonusNumber = input.askBonusNumber()
        val result = LottoResult(lottos.getLottoRanks(winningNumber, bonusNumber))
        output.printLottoRankResult(result.getResult())
        output.printGrossProfit(result.computeGrossProfit(output.purchaseAmount(ticketCount)))
    }
}